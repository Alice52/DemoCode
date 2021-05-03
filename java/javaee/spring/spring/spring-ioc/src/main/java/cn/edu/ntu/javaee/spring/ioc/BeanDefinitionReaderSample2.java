package cn.edu.ntu.javaee.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-07-17 20:04 <br>
 * @project spring <br>
 */
public class BeanDefinitionReaderSample2 {
    private static final Logger LOG = LoggerFactory.getLogger(BeanDefinitionReaderSample2.class);

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.setResourceLoader(new DefaultResourceLoader());
        reader.loadBeanDefinitions("ApplicationContext.xml");

        Arrays.stream(factory.getBeanDefinitionNames()).forEach(x -> LOG.info(x));
        LOG.info(factory.getBean("person").toString());
    }
}
