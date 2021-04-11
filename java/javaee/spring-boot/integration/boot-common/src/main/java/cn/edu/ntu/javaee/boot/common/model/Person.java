package cn.edu.ntu.javaee.boot.common.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

// this can inspect value to person object, then put it to IOC container.
// @PropertySource(value = { "classpath:person.properties" })
// @ConfigurationProperties(prefix = "person")
public class Person {

  private int age;

  @NotBlank private String name;
  private LocalDate birthDay;

  @ApiModelProperty(value = "country", required = true)
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;

    Person person = (Person) o;

    if (age != person.age) return false;
    if (gender != person.gender) return false;
    if (IdCard != person.IdCard) return false;
    if (name != null ? !name.equals(person.name) : person.name != null) return false;
    if (birthDay != null ? !birthDay.equals(person.birthDay) : person.birthDay != null)
      return false;
    return country != null ? country.equals(person.country) : person.country == null;
  }

  @Override
  public int hashCode() {
    int result = age;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (gender ? 1 : 0);
    result = 31 * result + (int) (IdCard ^ (IdCard >>> 32));
    return result;
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
