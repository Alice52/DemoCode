package boot.security.model.vo;

import boot.security.common.Constants;
import boot.security.model.entity.User;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * @author zack <br>
 * @create 2021-05-13 12:45 <br>
 * @project boot-security-shiro <br>
 */
@Data
public class OnlineUser {

    /** 主键 */
    private Long id;

    /** 用户名 */
    private String username;

    /** 昵称 */
    private String nickname;

    /** 手机 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 生日 */
    private Long birthday;

    /** 性别，男-1，女-2 */
    private Integer sex;

    public static OnlineUser create(User user) {
        OnlineUser onlineUser = new OnlineUser();
        BeanUtil.copyProperties(user, onlineUser);
        // 脱敏
        onlineUser.setPhone(StrUtil.hide(user.getPhone(), 3, 7));
        onlineUser.setEmail(
                StrUtil.hide(
                        user.getEmail(),
                        1,
                        StrUtil.indexOfIgnoreCase(user.getEmail(), Constants.SYMBOL_EMAIL)));
        return onlineUser;
    }
}
