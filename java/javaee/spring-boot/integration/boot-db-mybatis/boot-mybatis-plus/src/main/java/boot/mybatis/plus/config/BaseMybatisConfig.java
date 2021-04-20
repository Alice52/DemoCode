package boot.mybatis.plus.config;

import boot.mybatis.plus.config.handler.MybatisMetaHandler;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;

/**
 * @author zack <br>
 * @create 2021-04-20 17:28 <br>
 * @project boot-mybatis-common <br>
 */
public abstract class BaseMybatisConfig {
  @Bean
  public GlobalConfig globalConfig() {
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setMetaObjectHandler(new MybatisMetaHandler());
    return globalConfig;
  }
}
