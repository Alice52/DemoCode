package cn.edu.ntu.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Department {

  @NotBlank private String name;
  @NotNull private int Code;
  private String description;

  public Department() {}

  public Department(String name, int code, String description) {
    this.name = name;
    Code = code;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCode() {
    return Code;
  }

  public void setCode(int code) {
    Code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Department)) return false;

    Department that = (Department) o;

    if (Code != that.Code) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return description != null ? description.equals(that.description) : that.description == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + Code;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Department{"
        + "name='"
        + name
        + '\''
        + ", Code="
        + Code
        + ", description='"
        + description
        + '\''
        + '}';
  }
}
