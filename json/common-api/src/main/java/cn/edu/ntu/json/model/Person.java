package cn.edu.ntu.json.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-09-07 21:19 <br>
 * @project json <br>
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private FullName fullName;
    private int age;
    private Date birthday;
    private List<String> hobbies;
    private Map<String, String> clothes;
    private List<Person> friends;
}
