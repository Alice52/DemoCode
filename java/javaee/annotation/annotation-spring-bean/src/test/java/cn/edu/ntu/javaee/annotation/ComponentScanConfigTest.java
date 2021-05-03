package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.scan.ComponentScanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-29 18:06 <br>
 */
public class ComponentScanConfigTest {

    private ApplicationContext componentScanConfigApplicationContext =
            new AnnotationConfigApplicationContext(ComponentScanConfig.class);

    @Test
    public void testIocObjectsForComponentScanConfig() {
        String[] definitionNames = componentScanConfigApplicationContext.getBeanDefinitionNames();

        Arrays.stream(definitionNames).forEach(System.out::println);
    }
}
