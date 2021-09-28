package top.hubby.rwa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.hubby.rwa.model.RwaUser;

/**
 * @author asd <br>
 * @create 2021-09-28 4:51 PM <br>
 * @project boot-security-shiro <br>
 */
@Mapper
public interface UserMapper extends BaseMapper<RwaUser> {}
