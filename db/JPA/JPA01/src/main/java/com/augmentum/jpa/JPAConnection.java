package com.augmentum.jpa;


import javax.persistence.*;
import java.util.Date;

/**
 * @author zack
 * @create 2019-07-09 21:58
 * @function
 */
//关联数据表
@Table(name = "JPAEntity")
//持久化类
@Entity
public class JPAConnection {

    private Integer id;
    private String lastName;
    private int age;
    private Date birthDay;

    //    2.映射主键及数据列（在get方法上）
    //    数据列的列名( 如果相同可不写 ）
    //    @Column(name = "ID")
    //    生成主键的方式
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
