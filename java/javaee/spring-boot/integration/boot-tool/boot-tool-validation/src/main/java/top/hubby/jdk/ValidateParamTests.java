package top.hubby.jdk;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import top.hubby.jdk.model.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author asd <br>
 * @create 2022-03-04 5:52 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class ValidateParamTests {

    @Test
    public void test1() {
        Validator validator = ValidatorUtil.obtainValidator();

        Person person = new Person();
        person.setAge(-1);
        Set<ConstraintViolation<Person>> result = validator.validate(person);

        // 输出校验结果
        result.stream()
                .map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);
    }
}
