/**
 * @author zack
 * @create 2019-05-29 14:06
 * @function
 */
public class Address {
  private String city;
  private String province;

  public Address() {}

  public Address(String city, String province) {
    this.city = city;
    this.province = province;
  }

  @Override
  public String toString() {
    return "Address{" + "city='" + city + '\'' + ", province='" + province + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Address)) return false;

    Address address = (Address) o;

    if (!city.equals(address.city)) return false;
    return province.equals(address.province);
  }

  @Override
  public int hashCode() {
    int result = city.hashCode();
    result = 31 * result + province.hashCode();
    return result;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }
}
