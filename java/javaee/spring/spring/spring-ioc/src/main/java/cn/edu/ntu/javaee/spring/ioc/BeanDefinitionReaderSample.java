package cn.edu.ntu.javaee.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;

import java.util.Arrays;

/**
 * @author zack <br/>
 * @create 2020-07-17 19:41 <br/>
 * @project spring <br/>
 */
public class BeanDefinitionReaderSample {
    private static final Logger LOG = LoggerFactory.getLogger(BeanDefinitionReaderSample.class);

    public static void main(String[] args) {

        // 注册中心
        BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();
        // 读取器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(register);

        // 资源读取器
        DefaultResourceLoader loader = new DefaultResourceLoader();

        // 装载构建 bean 定义
        xmlBeanDefinitionReader.loadBeanDefinitions(loader.getResource("ApplicationContext.xml"));

        // org.springframework.context.support.PropertySourcesPlaceholderConfigurer#0
        // person4FactoryBean
        // person
        // dataSource
        // address
        // person4LifeCycle
        // cn.edu.ntu.javaee.spring.ioc.CustomBeanPostProcessor#0
        Arrays.stream(register.getBeanDefinitionNames()).forEach(x->LOG.info(x));
    }
}
