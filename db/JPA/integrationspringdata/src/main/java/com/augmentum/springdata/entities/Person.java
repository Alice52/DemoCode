package com.augmentum.springdata.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zack
 * @create 2019-08-10 22:13
 * @function
 */
@Entity
@Table(name = "person")
public class Person {
    private Integer id;
    private String lastName;

    private String email;
    private Date birthday;
    private int age;
    private Address address;

    private Integer addressId;

    @Column(name = "add_id")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @JoinColumn(name="address_id")
    @ManyToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", birthday=" + birthday + ", age=" + age + ", address=" + address + '}';
    }
}
