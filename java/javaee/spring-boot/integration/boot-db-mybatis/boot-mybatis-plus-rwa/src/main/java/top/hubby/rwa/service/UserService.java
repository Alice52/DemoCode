package top.hubby.rwa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hubby.rwa.model.RwaUser;

import java.util.List;

/**
 * @author asd <br>
 * @create 2021-09-28 4:57 PM <br>
 * @project boot-mybatis-rwa <br>
 */
public interface UserService extends IService<RwaUser> {
    List<RwaUser> listUser();

    int updateEntity();

    RwaUser find();
}
