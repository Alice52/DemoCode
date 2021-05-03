package cn.edu.ntu.javaee.spring.ioc;

import cn.edu.ntu.javaee.spring.common.constants.Constants;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author zack
 * @create 2019-10-27 12:43
 * @function test the syntax of bean
 */
public class BeanLifecycle {

    private static final Logger LOG = LoggerFactory.getLogger(BeanLifecycle.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_XML_PATH);

        Person person = ctx.getBean("person4LifeCycle", Person.class);
        LOG.info(
                "bean lifecycle: step6: use bean person: {} from IOC is success.",
                person.toString());
        ctx.close();
    }
}

/** @function: just used for test BeanLifeCycle */
class Person {
    private static final Logger LOG = LoggerFactory.getLogger(BeanLifecycle.class);

    @Max(value = 150, message = "you live too long")
    private int age;

    // 0: male, 1: female
    @Past private Date birthDay;
    @NotBlank private String name;
    private boolean gender;

    public Person() {
        LOG.info("bean lifecycle: step1: create bean by BeanFactory");
    }

    public Person(int age, Date birthDay, String name, boolean gender) {
        this.age = age;
        this.birthDay = birthDay;
        this.name = name;
        this.gender = gender;
        LOG.info("bean lifecycle: step1: create bean by BeanFactory");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        LOG.info("bean lifecycle: step2: set property for bean");
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{"
                + "age="
                + age
                + ", birthDay="
                + birthDay
                + ", name='"
                + name
                + '\''
                + ", gender="
                + gender
                + '}';
    }

    public void init() {
        LOG.info("bean lifecycle: step4: bean init method");
    }

    public void destroy() {
        LOG.info("bean lifecycle: step7:  bean destroy method");
    }
}
