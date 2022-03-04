package top.hubby.jdk;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import top.hubby.jdk.model.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author asd <br>
 * @create 2022-03-04 5:52 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class ValidateMethodTests {

    public class PersonService {
        /**
         *
         *
         * <pre>
         *    3. 代码侵入性强
         * </pre>
         *
         * @param id
         * @param name
         * @return
         */
        public Person getOneV2(@NotNull @Min(1) Integer id, String name)
                throws NoSuchMethodException {
            // 校验逻辑
            Method currMethod = this.getClass().getMethod("getOne", Integer.class, String.class);
            Set<ConstraintViolation<PersonService>> validResult =
                    obtainExecutableValidator()
                            .validateParameters(this, currMethod, new Object[] {id, name});
            if (!validResult.isEmpty()) {
                // ... 输出错误详情validResult
                validResult.stream()
                        .map(
                                v ->
                                        v.getPropertyPath()
                                                + " "
                                                + v.getMessage()
                                                + ": "
                                                + v.getInvalidValue())
                        .forEach(System.out::println);
                throw new IllegalArgumentException("参数错误");
            }

            return null;
        }

        /**
         *
         *
         * <pre>
         *    1. 这类代码没啥营养, 冗余复杂
         *    2. 没有形成契约
         *    3. 代码侵入性强
         * </pre>
         *
         * @param id
         * @param name
         * @return
         */
        public Person getOneV1(Integer id, String name) {
            if (id == null) {
                throw new IllegalArgumentException("id不能为null");
            }
            if (id < 1) {
                throw new IllegalArgumentException("id必须大于等于1");
            }

            return null;
        }
    }

    private Validator obtainValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }
    // 用于方法校验的校验器
    private ExecutableValidator obtainExecutableValidator() {
        return obtainValidator().forExecutables();
    }

    @Test
    public void test1() {
        Validator validator = obtainValidator();

        Person person = new Person();
        person.setAge(-1);
        Set<ConstraintViolation<Person>> result = validator.validate(person);

        // 输出校验结果
        result.stream()
                .map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);
    }
}
