package cn.edu.ntu.javaee.annotation.common.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2020-04-29 19:37 <br>
 */
@Slf4j
public class Person {

    private Integer age;
    private String name;

    public Person() {}

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    public void init() {
        log.info("Person object init method execute.");
    }

    public void destroy() {
        log.info("Person object destroy method execute.");
    }
}
