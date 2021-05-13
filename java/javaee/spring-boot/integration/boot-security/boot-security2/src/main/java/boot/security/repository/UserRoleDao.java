package boot.security.repository;

import boot.security.model.entity.UserRole;
import boot.security.model.entity.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zack <br>
 * @create 2021-05-13 12:42 <br>
 * @project boot-security-shiro <br>
 */
public interface UserRoleDao
        extends JpaRepository<UserRole, UserRoleKey>, JpaSpecificationExecutor<UserRole> {}
