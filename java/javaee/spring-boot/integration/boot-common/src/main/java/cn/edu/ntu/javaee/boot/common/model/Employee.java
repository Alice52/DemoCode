package cn.edu.ntu.javaee.boot.common.model;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Employee extends Person {
    @NotBlank private String Id;

    @Min(0)
    @Max(10)
    private int level;

    @Min(0)
    private double salary;

    @NotNull private Company company;

    @Min(0)
    private int WorkingAge;

    @Email private String email;
    @NotNull private Department department;
    @NotNull private int leaderId;

    public Employee() {}

    public Employee(
            int age,
            String name,
            LocalDate birthDay,
            String country,
            boolean gender,
            long idCard,
            String id,
            int level,
            double salary,
            Company company,
            int workingAge,
            String email,
            Department department,
            int leaderId) {
        super(age, name, birthDay, country, gender, idCard);
        Id = id;
        this.level = level;
        this.salary = salary;
        this.company = company;
        WorkingAge = workingAge;
        this.email = email;
        this.department = department;
        this.leaderId = leaderId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getWorkingAge() {
        return WorkingAge;
    }

    public void setWorkingAge(int workingAge) {
        WorkingAge = workingAge;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (level != employee.level) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (WorkingAge != employee.WorkingAge) return false;
        if (leaderId != employee.leaderId) return false;
        if (Id != null ? !Id.equals(employee.Id) : employee.Id != null) return false;
        if (company != null ? !company.equals(employee.company) : employee.company != null)
            return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        return department != null
                ? department.equals(employee.department)
                : employee.department == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (Id != null ? Id.hashCode() : 0);
        result = 31 * result + level;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + WorkingAge;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + leaderId;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "Id='"
                + Id
                + '\''
                + ", level="
                + level
                + ", salary="
                + salary
                + ", company="
                + company
                + ", WorkingAge="
                + WorkingAge
                + ", email='"
                + email
                + '\''
                + ", department="
                + department
                + ", leaderId="
                + leaderId
                + '}';
    }
}
