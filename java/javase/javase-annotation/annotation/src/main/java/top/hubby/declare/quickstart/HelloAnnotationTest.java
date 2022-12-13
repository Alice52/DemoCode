package top.hubby.declare.quickstart;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author alice52
 */
@Slf4j
public class HelloAnnotationTest {

    @SneakyThrows
    public static void main(String[] args) {
        HelloAnnotationUsage obj = new HelloAnnotationUsage();
        Class<?> clazz = obj.getClass();

        // 获取对象上的注解
        HelloAnnotation anno = clazz.getAnnotation(HelloAnnotation.class);
        log.info("class annotation:{}", anno);

        // 获取属性上的注解
        Field field = clazz.getDeclaredField("anno");
        anno = field.getAnnotation(HelloAnnotation.class);
        log.info("field annotation:{}", anno);

        // 获取方法上的注解
        Method method = clazz.getMethod("test", String.class);
        anno = method.getAnnotation(HelloAnnotation.class);
        log.info("method annotation:{}", anno);

        // 获取方法上的注解
        Annotation[][] pAnnos = method.getParameterAnnotations();
        log.info("parameter annotation:{}", pAnnos);
    }
}
