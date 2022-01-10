package cn.edu.ntu.springboot.mvc.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource(value = {"classpath:person.properties"})
// function as @Value, but bulk
@ConfigurationProperties(value = "person")
public class Person {
    private int age;
    private String name;

    private LocalDate birthDay;

    private String country;
    private boolean gender;
    private long IdCard;

    public Person() {}

    public Person(
            int age, String name, LocalDate birthDay, String country, boolean gender, long idCard) {
        this.age = age;
        this.name = name;
        this.birthDay = birthDay;
        this.country = country;
        this.gender = gender;
        IdCard = idCard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getIdCard() {
        return IdCard;
    }

    public void setIdCard(long idCard) {
        IdCard = idCard;
    }

    @Override
    public String toString() {
        return "Person{"
                + "age="
                + age
                + ", name='"
                + name
                + '\''
                + ", birthDay="
                + birthDay
                + ", country='"
                + country
                + '\''
                + ", gender="
                + gender
                + ", IdCard="
                + IdCard
                + '}';
    }
}
