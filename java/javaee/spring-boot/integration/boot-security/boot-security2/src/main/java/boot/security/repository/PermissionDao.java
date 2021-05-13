package boot.security.repository;

import boot.security.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zack <br>
 * @create 2021-05-13 12:41 <br>
 * @project boot-security-shiro <br>
 */
public interface PermissionDao
        extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {

    /**
     * 根据角色列表查询权限列表
     *
     * @param ids 角色id列表
     * @return 权限列表
     */
    @Query(
            value =
                    "SELECT DISTINCT boot_security2_permission.* "
                            + "FROM boot_security2_permission,boot_security2_role,boot_security2_role_permission "
                            + "WHERE boot_security2_role.id = boot_security2_role_permission.role_id AND boot_security2_permission.id = boot_security2_role_permission.permission_id "
                            + "AND boot_security2_role.id IN (:ids)",
            nativeQuery = true)
    List<Permission> selectByRoleIdList(@Param("ids") List<Long> ids);
}
