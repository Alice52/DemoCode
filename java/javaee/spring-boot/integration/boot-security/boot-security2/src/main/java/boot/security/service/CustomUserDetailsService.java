package boot.security.service;

import boot.security.model.entity.Permission;
import boot.security.model.entity.Role;
import boot.security.model.entity.User;
import boot.security.model.vo.UserPrincipal;
import boot.security.repository.PermissionDao;
import boot.security.repository.RoleDao;
import boot.security.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义UserDetails查询
 *
 * @author zack <br>
 * @create 2021-05-13 12:43 <br>
 * @project boot-security-shiro <br>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UserDao userDao;

    @Autowired private RoleDao roleDao;

    @Autowired private PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmailOrPhone)
            throws UsernameNotFoundException {
        User user =
                userDao.findByUsernameOrEmailOrPhone(
                                usernameOrEmailOrPhone,
                                usernameOrEmailOrPhone,
                                usernameOrEmailOrPhone)
                        .orElseThrow(
                                () ->
                                        new UsernameNotFoundException(
                                                "未找到用户信息 : " + usernameOrEmailOrPhone));
        List<Role> roles = roleDao.selectByUserId(user.getId());
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<Permission> permissions = permissionDao.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user, roles, permissions);
    }
}
