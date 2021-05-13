package boot.security.model.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author zack <br>
 * @create 2021-05-13 12:40 <br>
 * @project boot-security-shiro <br>
 */
@Data
@Entity
@Table(name = "boot_security2_role_permission")
public class RolePermission {
    /** 主键 */
    @EmbeddedId private RolePermissionKey id;
}
