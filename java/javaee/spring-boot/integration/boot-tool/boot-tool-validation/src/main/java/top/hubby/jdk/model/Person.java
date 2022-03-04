package top.hubby.jdk.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author asd <br>
 * @create 2022-03-04 5:53 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
@Data
public class Person {

    @NotNull public String name;

    @NotNull
    @Min(0)
    public Integer age;
}
