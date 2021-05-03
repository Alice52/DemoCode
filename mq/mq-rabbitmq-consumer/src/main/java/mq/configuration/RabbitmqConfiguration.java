package mq.configuration;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.springframework.amqp.support.converter.Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID;

/**
 * @author zack <br>
 * @create 2021-03-06 22:59 <br>
 * @project mq <br>
 */
@Component
public class RabbitmqConfiguration {

    @Bean
    public Jackson2JsonMessageConverter converter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setTypePrecedence(TYPE_ID);
        return converter;
    }
}
