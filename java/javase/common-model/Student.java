/**
 * @author zack
 * @create 2019-06-11 16:09
 * @function
 */
public class Student extends Person {
    private String school;

    public Student() {
    }

    public Student(int age, String name, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {

        return "Student [age=" + super.getAge() + ", name=" + super.getName() + " [school=" + school + "]";
    }
}
