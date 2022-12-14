package cn.edu.ntu.java.javase.reflect.classapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.*;

/**
 * @author zack <br>
 * @create 2020-04-04 23:48 <br>
 */
public class AnnotatedElementTest {
    private static final Logger LOG = LoggerFactory.getLogger(AnnotatedElementTest.class);

    public static void main(String... args) {
        for (Annotation annotation : A.class.getAnnotations()) {
            LOG.info("" + annotation);
        }

        LOG.info("getAnnotation: " + A.class.getAnnotation(TestAnn1.class));
        LOG.info("isAnnotationPresent: " + A.class.isAnnotationPresent(TestAnn1.class));
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnn1 {
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnn2 {
    }

    @TestAnn1
    @TestAnn2
    public class A {
    }
}
