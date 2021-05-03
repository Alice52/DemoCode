package boot.mybatis.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author zack <br>
 * @create 2021-04-25<br>
 * @project integration <br>
 */
@Configuration
public class AsyncPoolConfig {
    private static final int MAX_POOL_SIZE;
    private static final int CORE_POOL_SIZE;
    private static final int QUEUE_SIZE;

    static {
        int processors = Runtime.getRuntime().availableProcessors();
        MAX_POOL_SIZE = (int) (processors / (1 - 0.9));
        CORE_POOL_SIZE = processors;
        QUEUE_SIZE = MAX_POOL_SIZE * 3;
    }

    @Bean("asyncPoolExecutor")
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        asyncTaskExecutor.setQueueCapacity(QUEUE_SIZE);
        asyncTaskExecutor.setThreadNamePrefix("async-pool-");
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }
}
