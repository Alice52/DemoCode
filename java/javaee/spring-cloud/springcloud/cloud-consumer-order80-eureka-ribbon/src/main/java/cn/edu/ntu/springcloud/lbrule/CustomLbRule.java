package cn.edu.ntu.springcloud.lbrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br/>
 * @create 2020-04-01 20:43 <br/>
 */
@Configuration
public class CustomLbRule {

    @Bean
    public IRule customRule() {
        return new RandomRule();
    }
}
