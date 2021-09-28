package boot.mybatis.plus.service;

import boot.mybatis.common.model.entity.BaseEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author asd <br/>
 * @create 2021-09-28 2:21 PM <br/>
 * @project boot-security-shiro <br/>
 */
public interface IBaseService <T extends BaseEntity> extends IService<T> {

    /**
     * build common lambda query wrapper.
     *
     * @return
     */
    default LambdaQueryWrapper<T> buildQueryWrapper() {
        return Wrappers.<T>query().lambda();
    }

    /**
     * build common lambda query one wrapper.
     *
     * @return
     */
    default LambdaQueryWrapper<T> buildOneQueryWrapper() {
        return buildQueryWrapper().last("LIMIT 1");
    }
}
