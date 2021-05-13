package boot.security.util;

import boot.security.common.Constants;
import boot.security.config.JwtConfig;
import boot.security.constants.enums.SecurityResponseEnum;
import boot.security.model.vo.UserPrincipal;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2021-05-13 12:43 <br>
 * @project boot-security-shiro <br>
 */
@EnableConfigurationProperties(JwtConfig.class)
@Configuration
@Slf4j
public class JwtUtil {
    @Autowired private JwtConfig jwtConfig;

    @Autowired private StringRedisTemplate stringRedisTemplate;

    /**
     * 创建JWT
     *
     * @param rememberMe 记住我
     * @param id 用户id
     * @param subject 用户名
     * @param roles 用户角色
     * @param authorities 用户权限
     * @return JWT
     */
    public String createJWT(
            Boolean rememberMe,
            Long id,
            String subject,
            List<String> roles,
            Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        JwtBuilder builder =
                Jwts.builder()
                        .setId(id.toString())
                        .setSubject(subject)
                        .setIssuedAt(now)
                        .signWith(SignatureAlgorithm.HS256, jwtConfig.getKey())
                        .claim("roles", roles)
                        .claim("authorities", authorities);

        // 设置过期时间
        Long ttl = rememberMe ? jwtConfig.getRemember() : jwtConfig.getTtl();
        if (ttl > 0) {
            builder.setExpiration(DateUtil.offsetMillisecond(now, ttl.intValue()));
        }

        String jwt = builder.compact();
        // 将生成的JWT保存至Redis
        stringRedisTemplate
                .opsForValue()
                .set(Constants.REDIS_JWT_KEY_PREFIX + subject, jwt, ttl, TimeUnit.MILLISECONDS);
        return jwt;
    }

    /**
     * 创建JWT
     *
     * @param authentication 用户认证信息
     * @param rememberMe 记住我
     * @return JWT
     */
    public String createJWT(Authentication authentication, Boolean rememberMe) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return createJWT(
                rememberMe,
                userPrincipal.getId(),
                userPrincipal.getUsername(),
                userPrincipal.getRoles(),
                userPrincipal.getAuthorities());
    }

    /**
     * 解析JWT
     *
     * @param jwt JWT
     * @return {@link Claims}
     */
    public Claims parseJWT(String jwt) {
        try {
            Claims claims =
                    Jwts.parser().setSigningKey(jwtConfig.getKey()).parseClaimsJws(jwt).getBody();

            String username = claims.getSubject();
            String redisKey = Constants.REDIS_JWT_KEY_PREFIX + username;

            // 校验redis中的JWT是否存在
            Long expire = stringRedisTemplate.getExpire(redisKey, TimeUnit.MILLISECONDS);
            if (Objects.isNull(expire) || expire <= 0) {
                SecurityResponseEnum.NO_AUTHORIZATION.assertFailWithMsg("token 已过期，请重新登录！");
            }

            // 校验redis中的JWT是否与当前的一致，不一致则代表用户已注销/用户在不同设备登录，均代表JWT已过期
            String redisToken = stringRedisTemplate.opsForValue().get(redisKey);
            if (!StrUtil.equals(jwt, redisToken)) {
                SecurityResponseEnum.NO_AUTHORIZATION.assertFailWithMsg("当前用户已在别处登录，请尝试更改密码或重新登录！");
            }
            return claims;
        } catch (ExpiredJwtException e) {
            log.error("Token 已过期");
            SecurityResponseEnum.NO_AUTHORIZATION.assertFailWithMsg("token 已过期，请重新登录！");
        } catch (UnsupportedJwtException e) {
            log.error("不支持的 Token");
            SecurityResponseEnum.NO_AUTHORIZATION.assertFail2Response(5002, "token 解析失败，请尝试重新登录！");
        } catch (MalformedJwtException e) {
            log.error("Token 无效");
            SecurityResponseEnum.NO_AUTHORIZATION.assertFailWithMsg("Token 无效");
        } catch (IllegalArgumentException e) {
            log.error("Token 参数不存在");
            SecurityResponseEnum.NO_AUTHORIZATION.assertFailWithMsg("Token 参数不存在！");
        }

        return null;
    }

    /**
     * 设置JWT过期
     *
     * @param request 请求
     */
    public void invalidateJWT(HttpServletRequest request) {
        String jwt = getJwtFromRequest(request);
        String username = getUsernameFromJWT(jwt);
        // 从redis中清除JWT
        stringRedisTemplate.delete(Constants.REDIS_JWT_KEY_PREFIX + username);
    }

    /**
     * 根据 jwt 获取用户名
     *
     * @param jwt JWT
     * @return 用户名
     */
    public String getUsernameFromJWT(String jwt) {
        Claims claims = parseJWT(jwt);
        return claims.getSubject();
    }

    /**
     * 从 request 的 header 中获取 JWT
     *
     * @param request 请求
     * @return JWT
     */
    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StrUtil.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
