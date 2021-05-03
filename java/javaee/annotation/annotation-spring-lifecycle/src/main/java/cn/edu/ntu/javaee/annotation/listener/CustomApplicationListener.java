package cn.edu.ntu.javaee.annotation.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zack <br>
 * @create 2020-05-08 20:09 <br>
 * @project annotation <br>
 */
@Slf4j
public class CustomApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("event: {}", event);
    }
}
