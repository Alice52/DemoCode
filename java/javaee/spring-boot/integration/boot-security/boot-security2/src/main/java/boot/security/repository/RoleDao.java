package boot.security.repository;

import boot.security.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zack <br>
 * @create 2021-05-13 12:42 <br>
 * @project boot-security-shiro <br>
 */
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    /**
     * 根据用户id 查询角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @Query(
            value =
                    "SELECT boot_security2_role.* "
                            + "FROM boot_security2_role,boot_security2_user,boot_security2_user_role "
                            + "WHERE boot_security2_user.id = boot_security2_user_role.user_id AND boot_security2_role.id = boot_security2_user_role.role_id AND boot_security2_user.id = :userId",
            nativeQuery = true)
    List<Role> selectByUserId(@Param("userId") Long userId);
}
