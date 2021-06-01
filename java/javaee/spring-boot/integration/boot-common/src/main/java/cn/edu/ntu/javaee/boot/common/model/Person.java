package cn.edu.ntu.javaee.boot.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

// this can inspect value to person object, then put it to IOC container.
// @PropertySource(value = { "classpath:person.properties" })
// @ConfigurationProperties(prefix = "person")
@Builder
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Person {

    private int age;

    @NotBlank private String name;
    private LocalDate birthDay;

    @ApiModelProperty(value = "country", required = true)
    private String country;

    private boolean gender;
    private long IdCard;

    public Person(
            int age, String name, LocalDate birthDay, String country, boolean gender, long idCard) {
        this.age = age;
        this.name = name;
        this.birthDay = birthDay;
        this.country = country;
        this.gender = gender;
        IdCard = idCard;
    }
}
