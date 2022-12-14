package cn.edu.ntu.java.declare.quickstart;

import lombok.Data;

/**
 * @author alice52
 */
@Data
@HelloAnnotation(age = 12, major = "class")
public class HelloAnnotationUsage {

    @HelloAnnotation(age = 12, major = "field")
    private String anno;

    @HelloAnnotation(age = 12, major = "method")
    public void test(@HelloAnnotation(age = 12, major = "parameter") String anno) {}
}
