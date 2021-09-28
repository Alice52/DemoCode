package top.hubby.rwa.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * AbstractRoutingDataSource 基于特定的查找key路由到特定的数据源。它内部维护了一组目标数据源，
 * 并且做了路由key与目标数据源之间的映射，提供基于key查找数据源的方法。 就是这个类来切换数据源的 在多个数据源之间切换。 继承它 那么 DynamicDataSource也就是决定路由切换
 * 的类
 *
 * @author asd <br>
 * @create 2021-09-28 4:44 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
