package cn.edu.ntu.java.javase.classloader;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Optional;

/**
 * @author zack <br>
 * @create 2021-03-02 10:26 <br>
 * @project javase <br>
 */
@Slf4j
public class SalaryStealing {

    @SneakyThrows
    public static void main(String[] args) {

        // v1
        double salary = 2000.00;
        cal(salary);

        // v2
        URLClassLoader loader = new URLClassLoader(new URL[]{new URL("")});
        calV2(salary, loader);

        // v3: hot load
        calHotLoad(salary);
    }

    public static Double cal(Double salary) {

        return salary * 1.2;
    }

    @SneakyThrows
    public static Double calV2(Double salary, ClassLoader loader) {
        Class<?> aClass = loader.loadClass("CLASS_FULL_NAME");
        aClass.newInstance();
        Method method = aClass.getMethod("cal", Double.class);
        Double rSalary = (Double) method.invoke(aClass, salary);

        Optional.ofNullable(rSalary).ifPresent(System.out::println);
        return rSalary;
    }

    @SneakyThrows
    public static Double calHotLoad(Double salary) {

        SalaryClassLoader hotLoader = new SalaryClassLoader("");
        Class<?> aClass = hotLoader.loadClass("CLASS_FULL_NAME");
        aClass.newInstance();
        Method method = aClass.getMethod("cal", Double.class);
        Double rSalary = (Double) method.invoke(aClass, salary);

        return rSalary;
    }
}
