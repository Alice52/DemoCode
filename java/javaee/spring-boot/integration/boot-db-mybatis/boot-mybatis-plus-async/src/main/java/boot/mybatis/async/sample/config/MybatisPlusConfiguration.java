package boot.mybatis.async.sample.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br>
 * @create 2021-04-25<br>
 * @project integration <br>
 */
@Configuration
public class MybatisPlusConfiguration {

    /**
     * 逻辑删除:
     *
     * <pre>
     *    在这个配置类中注入 LogicSqlInjector bean 对象的原因是:<br>
     *      1. 若mp的版本是3.3.1以下的就需要在此处注入这个bean对象<br>
     *      2. 若mp的版本高于3.3.1的就无需在此处注入bean对象了
     * </pre>
     *
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
