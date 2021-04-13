package boot.cache.sample.configuration;

import boot.cache.sample.component.datascope.DataScopeInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br>
 * @create 2021-04-09 12:29 <br>
 * @project integration <br>
 */
@Configuration
@EnableCaching
@MapperScan("boot.cache.sample.mapper")
public class MybatisPlusConfigure {
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
}
