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
}
