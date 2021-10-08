package boot.mybatis.async.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 自定义子线程 UncaughtException 处理器, 默认就可以捕获.
 *
 * @author zack <br>
 * @create 2021-05-31 17:05 <br>
 * @project boot-mybatis-plus-async <br>
 */
@Configuration
@Slf4j
public class SpringAsyncConfiguration implements AsyncConfigurer {

    private static final int MAX_POOL_SIZE;
    private static final int CORE_POOL_SIZE;
    private static final int QUEUE_SIZE;

    static {
        int processors = Runtime.getRuntime().availableProcessors();
        MAX_POOL_SIZE = (int) (processors / (1 - 0.9));
        CORE_POOL_SIZE = processors;
        QUEUE_SIZE = MAX_POOL_SIZE * 3;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    @Override
    public AsyncTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        asyncTaskExecutor.setQueueCapacity(QUEUE_SIZE);
        asyncTaskExecutor.setThreadNamePrefix("async-pool-");
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }
}
