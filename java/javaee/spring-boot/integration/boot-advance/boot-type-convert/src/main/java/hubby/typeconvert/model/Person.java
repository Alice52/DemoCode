package hubby.typeconvert.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2022-01-19 5:10 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
@Data
public class Person {
    private Long id;
    private String name;
    private Cat cat;
}
