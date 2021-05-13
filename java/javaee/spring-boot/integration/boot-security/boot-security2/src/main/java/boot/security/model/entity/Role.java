package boot.security.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zack <br>
 * @create 2021-05-13 12:40 <br>
 * @project boot-security-shiro <br>
 */
@Data
@Entity
@Table(name = "boot_security2_role")
public class Role {
    /** 主键 */
    @Id private Long id;

    /** 角色名 */
    private String name;

    /** 描述 */
    private String description;

    /** 创建时间 */
    @Column(name = "create_time")
    private Long createTime;

    /** 更新时间 */
    @Column(name = "update_time")
    private Long updateTime;
}
