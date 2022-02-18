package hubby.typeconvert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2022-01-19 5:10 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private Cat cat;

    /** 方法名称可以是：valueOf、of、from */
    public static Person valueOf(Customer customer) {
        Person person = new Person();
        person.setId(customer.getId());
        person.setName("YourBatman-".concat(customer.getName()));
        return person;
    }

    public Person(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
    }

    /** 根据 ID 定位一个Person实例 */
    public static Person findPerson(Long id) {
        // 一般根据id从数据库查, 本处通过new来模拟
        Person person = new Person();
        person.setId(id);
        person.setName("YourBatman-byFindPerson");
        return person;
    }
}
