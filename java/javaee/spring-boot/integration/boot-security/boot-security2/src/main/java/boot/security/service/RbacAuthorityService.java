package boot.security.service;

import boot.security.common.Constants;
import boot.security.constants.enums.SecurityResponseEnum;
import boot.security.model.entity.Permission;
import boot.security.model.entity.Role;
import boot.security.model.vo.UserPrincipal;
import boot.security.repository.PermissionDao;
import boot.security.repository.RoleDao;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zack <br>
 * @create 2021-05-13 12:15 <br>
 * @project boot-security-shiro <br>
 */
@Component
public class RbacAuthorityService {
    @Autowired private RoleDao roleDao;

    @Autowired private PermissionDao permissionDao;

    @Autowired private RequestMappingHandlerMapping mapping;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        checkRequest(request);

        Object userInfo = authentication.getPrincipal();
        boolean hasPermission = false;

        if (userInfo instanceof UserDetails) {
            UserPrincipal principal = (UserPrincipal) userInfo;
            Long userId = principal.getId();

            List<Role> roles = roleDao.selectByUserId(userId);
            List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
            List<Permission> permissions = permissionDao.selectByRoleIdList(roleIds);

            // 获取资源，前后端分离，所以过滤页面权限，只保留按钮权限
            List<Permission> btnPerms =
                    permissions.stream()
                            // 过滤页面权限
                            .filter(
                                    permission ->
                                            Objects.equals(permission.getType(), Constants.BUTTON))
                            // 过滤 URL 为空
                            .filter(permission -> StrUtil.isNotBlank(permission.getUrl()))
                            // 过滤 METHOD 为空
                            .filter(permission -> StrUtil.isNotBlank(permission.getMethod()))
                            .collect(Collectors.toList());

            for (Permission btnPerm : btnPerms) {
                AntPathRequestMatcher antPathMatcher =
                        new AntPathRequestMatcher(btnPerm.getUrl(), btnPerm.getMethod());
                if (antPathMatcher.matches(request)) {
                    hasPermission = true;
                    break;
                }
            }

            return hasPermission;
        } else {
            return false;
        }
    }

    /**
     * 校验请求是否存在
     *
     * @param request 请求
     */
    private void checkRequest(HttpServletRequest request) {
        // 获取当前 request 的方法
        String currentMethod = request.getMethod();
        Map<String, List<String>> urlMapping = new HashMap<>();

        for (String uri : urlMapping.keySet()) {
            // 通过 AntPathRequestMatcher 匹配 url
            // 可以通过 2 种方式创建 AntPathRequestMatcher
            // 1：new AntPathRequestMatcher(uri,method) 这种方式可以直接判断方法是否匹配，因为这里我们把 方法不匹配
            // 自定义抛出，所以，我们使用第2种方式创建
            // 2：new AntPathRequestMatcher(uri) 这种方式不校验请求方法，只校验请求路径
            AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(uri);
            if (antPathMatcher.matches(request)) {
                if (!urlMapping.get(uri).contains(currentMethod)) {
                    SecurityResponseEnum.NO_PERMISSION.assertFail();
                } else {
                    return;
                }
            }
        }

        SecurityResponseEnum.NO_FOUND.assertFail();
    }
}
