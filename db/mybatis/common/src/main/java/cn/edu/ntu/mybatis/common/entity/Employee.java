package cn.edu.ntu.mybatis.common.entity;

import javax.validation.constraints.Email;

/**
 * @author zack <br>
 * @create 2020-06-15 20:46 <br>
 * @project mybatis <br>
 */
public class Employee {
    private Integer id;
    private String lastName;

    /** this annotation just work for controller?? */
    @Email private String email;

    private String gender;
    private Department dept;

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id="
                + id
                + ", lastName='"
                + lastName
                + '\''
                + ", email='"
                + email
                + '\''
                + ", gender='"
                + gender
                + '\''
                + ", dept="
                + dept
                + '}';
    }
}
