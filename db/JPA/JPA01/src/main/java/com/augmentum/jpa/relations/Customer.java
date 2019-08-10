package com.augmentum.jpa.relations;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zack
 * @create 2019-07-14 16:13
 * @function
 */
@Entity
@Table(name = "jpa_relations_customer")
public class Customer {
    private Integer id;
    private String lastName;
    private int age;
    private Date birthDay;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    @Temporal(TemporalType.TIME)
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Last_Name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
