package cn.edu.ntu.javaee.annotation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-04-30 16:03 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cat {

  @Value("#{20-15}")
  private Integer age;

  @Value("zack")
  private String name;

  @Value("${color:blue}")
  private String color;

  @Value("${os.name}")
  private String os;

  private String owner;

  private static String weight;

  public static String getWeight() {
    return weight;
  }

  @Value("${weight}")
  public void setWeight(String weight) {
    Cat.weight = weight;
  }
}
