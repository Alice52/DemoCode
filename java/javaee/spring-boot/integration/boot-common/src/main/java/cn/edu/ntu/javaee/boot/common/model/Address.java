package cn.edu.ntu.javaee.boot.common.model;

import javax.validation.constraints.NotBlank;

public class Address {

  @NotBlank private String Province;
  @NotBlank private String City;
  @NotBlank private String County;
  @NotBlank private String Street;
  @NotBlank private String Postcode;

  public Address() {}

  public Address(String province, String city, String county, String street, String postcode) {
    Province = province;
    City = city;
    County = county;
    Street = street;
    Postcode = postcode;
  }

  public String getProvince() {
    return Province;
  }

  public void setProvince(String province) {
    Province = province;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String city) {
    City = city;
  }

  public String getCounty() {
    return County;
  }

  public void setCounty(String county) {
    County = county;
  }

  public String getStreet() {
    return Street;
  }

  public void setStreet(String street) {
    Street = street;
  }

  public String getPostcode() {
    return Postcode;
  }

  public void setPostcode(String postcode) {
    Postcode = postcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Address)) return false;

    Address address = (Address) o;

    if (Province != null ? !Province.equals(address.Province) : address.Province != null)
      return false;
    if (City != null ? !City.equals(address.City) : address.City != null) return false;
    if (County != null ? !County.equals(address.County) : address.County != null) return false;
    if (Street != null ? !Street.equals(address.Street) : address.Street != null) return false;
    return Postcode != null ? Postcode.equals(address.Postcode) : address.Postcode == null;
  }

  @Override
  public int hashCode() {
    int result = Province != null ? Province.hashCode() : 0;
    result = 31 * result + (City != null ? City.hashCode() : 0);
    result = 31 * result + (County != null ? County.hashCode() : 0);
    result = 31 * result + (Street != null ? Street.hashCode() : 0);
    result = 31 * result + (Postcode != null ? Postcode.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Address{"
        + "Province='"
        + Province
        + '\''
        + ", City='"
        + City
        + '\''
        + ", County='"
        + County
        + '\''
        + ", Street='"
        + Street
        + '\''
        + ", Postcode='"
        + Postcode
        + '\''
        + '}';
  }
}
