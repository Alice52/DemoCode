package cn.edu.ntu.javaee.spring.common.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author zack
 * @create 2019-10-27 13:01
 * @function
 */
public class Person {

    @Max(value = 150, message = "you live too long")
    private int age;

    @Past private Date birthDay;
    @NotBlank private String name;
    private boolean gender; // 0: male, 1: female
    private Address address;

    @Email(message = "Invalid Email")
    private String email;

    @Min(value = 0, message = "salary must be over zero")
    private double salary;

    private String bookName;

    public Person() {
        System.out.println("ads");
    }

    public Person(
            int age,
            Date birthDay,
            String name,
            boolean gender,
            Address address,
            String email,
            double salary) {
        this.age = age;
        this.birthDay = birthDay;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.salary = salary;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (gender != person.gender) return false;
        if (Double.compare(person.salary, salary) != 0) return false;
        if (birthDay != null ? !birthDay.equals(person.birthDay) : person.birthDay != null)
            return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null)
            return false;
        return email != null ? email.equals(person.email) : person.email == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
                + ", address="
                + address
                + ", email='"
                + email
                + '\''
                + ", salary="
                + salary
                + ", bookName='"
                + bookName
                + '\''
                + '}';
    }
}
