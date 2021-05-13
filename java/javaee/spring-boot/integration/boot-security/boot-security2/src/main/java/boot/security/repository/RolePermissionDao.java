package boot.security.repository;

import boot.security.model.entity.RolePermission;
import boot.security.model.entity.RolePermissionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zack <br>
 * @create 2021-05-13 12:42 <br>
 * @project boot-security-shiro <br>
 */
public interface RolePermissionDao
        extends JpaRepository<RolePermission, RolePermissionKey>,
                JpaSpecificationExecutor<RolePermission> {}
