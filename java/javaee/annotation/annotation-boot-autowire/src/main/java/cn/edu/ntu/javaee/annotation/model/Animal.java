package cn.edu.ntu.javaee.annotation.model;

import cn.edu.ntu.javaee.annotation.common.model.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-04-30 18:21 <br>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Component
public class Animal {

  private Integer age;

  private Dog dog;

  public Dog getDog() {
    return dog;
  }

  /**
   *
   * @param dog the value get from ioc container.
   */
  @Autowired
  public void setDog(Dog dog) {
    this.dog = dog;
  }
}
