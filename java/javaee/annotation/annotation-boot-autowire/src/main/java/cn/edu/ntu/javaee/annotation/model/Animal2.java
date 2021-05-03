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
 * @create 2020-04-30 18:30 <br>
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Component
public class Animal2 {
    private Integer age;
    private Dog dog;

    @Autowired
    public Animal2(Dog dog) {
        this.dog = dog;
    }

    //    public Animal2(@Autowired Dog dog) {
    //        this.dog = dog;
    //    }
}
