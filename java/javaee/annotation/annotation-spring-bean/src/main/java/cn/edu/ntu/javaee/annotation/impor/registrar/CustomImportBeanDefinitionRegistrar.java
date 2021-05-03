package cn.edu.ntu.javaee.annotation.impor.registrar;

import cn.edu.ntu.javaee.annotation.common.model.Student;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zack <br>
 * @create 2020-04-29 22:02 <br>
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * manual add bean to IOC container. <br>
     *
     * @param metadata annotation metadata of the importing class
     * @param registry current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata metadata, BeanDefinitionRegistry registry) {

        MergedAnnotations annotations = metadata.getAnnotations();

        annotations.stream().forEach(System.out::println);

        boolean containsStudentBeanDefinition = registry.containsBeanDefinition("student");
        if (!containsStudentBeanDefinition) {
            registry.registerBeanDefinition("student", new RootBeanDefinition(Student.class));
        }
    }
}
