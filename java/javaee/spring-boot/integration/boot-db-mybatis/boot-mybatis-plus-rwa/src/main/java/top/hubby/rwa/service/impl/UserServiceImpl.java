package top.hubby.rwa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.hubby.rwa.constants.enums.DynamicDataSourceEnum;
import top.hubby.rwa.dynamic.DataSourceSelector;
import top.hubby.rwa.mapper.UserMapper;
import top.hubby.rwa.model.RwaUser;
import top.hubby.rwa.service.UserService;

import java.util.List;

/**
 * @author asd <br>
 * @create 2021-09-28 4:59 PM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, RwaUser> implements UserService {

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public List<RwaUser> listUser() {
        List<RwaUser> users = this.list();
        return users;
    }

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.MASTER)
    public int updateEntity() {
        RwaUser rwaUser = find();
        rwaUser.setUserName("修改后的名字2");

        return baseMapper.updateById(rwaUser);
    }

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public RwaUser find() {

        LambdaQueryWrapper<RwaUser> wrapper =
                Wrappers.<RwaUser>query().lambda().orderByDesc(RwaUser::getUserId).last("LIMIT 1");

        return this.getOne(wrapper);
    }
}
