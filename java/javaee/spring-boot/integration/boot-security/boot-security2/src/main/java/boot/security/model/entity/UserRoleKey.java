package boot.security.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author zack <br>
 * @create 2021-05-13 12:39 <br>
 * @project boot-security-shiro <br>
 */
@Embeddable
@Data
public class UserRoleKey implements Serializable {
    private static final long serialVersionUID = 5633412144183654743L;

    /** 用户id */
    @Column(name = "user_id")
    private Long userId;

    /** 角色id */
    @Column(name = "role_id")
    private Long roleId;
}
