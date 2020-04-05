package  cn.edu.ntu.javaee.spring.common.entity;

/**
 * @author zack
 * @create 2019-10-27 13:09
 * @function
 */
public class Children {

  private String name;
  private int age;
  private Person parent;

  public Children() {}

  public Children(String name, int age, Person parent) {
    this.name = name;
    this.age = age;
    this.parent = parent;
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

  public Person getParent() {
    return parent;
  }

  public void setParent(Person parent) {
    this.parent = parent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Children)) return false;

    Children children = (Children) o;

    if (age != children.age) return false;
    if (name != null ? !name.equals(children.name) : children.name != null) return false;
    return parent != null ? parent.equals(children.parent) : children.parent == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + age;
    result = 31 * result + (parent != null ? parent.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Children{" + "name='" + name + '\'' + ", age=" + age + ", parent=" + parent + '}';
  }
}
