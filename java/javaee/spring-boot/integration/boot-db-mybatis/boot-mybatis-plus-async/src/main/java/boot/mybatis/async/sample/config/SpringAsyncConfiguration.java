package boot.mybatis.async.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.lang.reflect.Method;

/**
 * 自定义子线程 UncaughtException 处理器, 默认就可以捕获.
 *
 * @see AsyncPoolConfig
 * @author zack <br>
 * @create 2021-05-31 17:05 <br>
 * @project boot-mybatis-plus-async <br>
 */
@Configuration
@Slf4j
public class SpringAsyncConfiguration implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (Throwable throwable, Method method, Object... obj) -> log.error("", throwable);
    }
}
