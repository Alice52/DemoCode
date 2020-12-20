package cn.edu.ntu.javaee.boot.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author zack
 * @create 2019-12-22 18:51
 * @function
 */
public class Company {

  @NotNull private Address address;
  @NotBlank private String name;
  @Past private Date Established;
  @NotBlank private String LegalPerson;

  public Company() {}

  public Company(Address address, String name, Date established, String legalPerson) {
    this.address = address;
    this.name = name;
    Established = established;
    LegalPerson = legalPerson;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getEstablished() {
    return Established;
  }

  public void setEstablished(Date established) {
    Established = established;
  }

  public String getLegalPerson() {
    return LegalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    LegalPerson = legalPerson;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Company)) return false;

    Company company = (Company) o;

    if (address != null ? !address.equals(company.address) : company.address != null) return false;
    if (name != null ? !name.equals(company.name) : company.name != null) return false;
    if (Established != null
        ? !Established.equals(company.Established)
        : company.Established != null) return false;
    return LegalPerson != null
        ? LegalPerson.equals(company.LegalPerson)
        : company.LegalPerson == null;
  }

  @Override
  public int hashCode() {
    int result = address != null ? address.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (Established != null ? Established.hashCode() : 0);
    result = 31 * result + (LegalPerson != null ? LegalPerson.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Company{"
        + "address="
        + address
        + ", name='"
        + name
        + '\''
        + ", Established="
        + Established
        + ", LegalPerson='"
        + LegalPerson
        + '\''
        + '}';
  }
}
