package cn.edu.ntu.javase.common.model;

/**
 * @author zack <br>
 * @create 2020-04-04 15:31 <br>
 */
public class Student extends Person {
  private String school;

  public Student() {}

  public Student(int age, String name, String school) {
    super(name, age);
    this.school = school;
  }

  public Student(String name, int age) {
    super(name, age);
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  @Override
  public String toString() {

    return "Student [age="
        + super.getAge()
        + ", name="
        + super.getName()
        + " [school="
        + school
        + "]";
  }
}
