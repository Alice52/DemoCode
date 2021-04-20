package boot.mybatis.plus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zack <br>
 * @create 2021-04-09 12:29 <br>
 * @project integration <br>
 */
@Configuration
@MapperScan("boot.mybatis.plus.mapper")
public class MybatisPlusConfigure extends BaseMybatisConfig{
  /**
   * 分页插件
   *
   * @return PaginationInterceptor
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

  /**
   * 数据权限插件
   *
   * @return DataScopeInterceptor
   */
  @Bean
  public DataScopeInterceptor dataScopeInterceptor() {
    return new DataScopeInterceptor();
  }

  /**
   * 逻辑删除
   *
   * @return
   */
  @Bean
  public ISqlInjector sqlInjector() {
    return new LogicSqlInjector();
  }

  /** SQL执行效率插件 */
  @Bean
  @Profile({"dev", "cloud"}) // 设置 dev demo staging 环境开启
  public PerformanceInterceptor performanceInterceptor() {
    return new PerformanceInterceptor();
  }
}
