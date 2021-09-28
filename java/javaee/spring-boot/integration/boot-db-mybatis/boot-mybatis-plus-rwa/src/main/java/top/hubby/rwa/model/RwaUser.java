package top.hubby.rwa.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author asd <br>
 * @create 2021-09-28 4:50 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@Data
@TableName("user")
public class RwaUser {
    @TableId private Long userId;

    private String userName;

    private String userPhone;

    private String address;

    private Integer weight;

    private Date createdAt;

    private Date updatedAt;
}
