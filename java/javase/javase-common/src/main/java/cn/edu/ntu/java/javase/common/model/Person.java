package cn.edu.ntu.java.javase.common.model;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author zack <br>
 * @create 2020-04-04 15:30 <br>
 */
@EqualsAndHashCode
public class Person implements Serializable {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    /** test for Reflect */
    public void testReflect() {
        System.out.println("Reflect");
    }

    public void testReflect2(String str, Integer integer) {
        System.out.println("Reflect2: " + str + "-" + integer);
    }
}
