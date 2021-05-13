package boot.security.repository;

import boot.security.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @author zack <br>
 * @create 2021-05-13 12:42 <br>
 * @project boot-security-shiro <br>
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * 根据用户名、邮箱、手机号查询用户
     *
     * @param username 用户名
     * @param email 邮箱
     * @param phone 手机号
     * @return 用户信息
     */
    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);

    /**
     * 根据用户名列表查询用户列表
     *
     * @param usernameList 用户名列表
     * @return 用户列表
     */
    List<User> findByUsernameIn(List<String> usernameList);
}
