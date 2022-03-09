package top.hubby.jdk;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import top.hubby.jdk.model.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author asd <br>
 * @create 2022-03-04 5:52 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class ValidateMethodTests {

    @Test
    public void testMethodV3() throws NoSuchMethodException {

        PersonService service = new PersonService();
        ArrayList<String> list = new ArrayList<>();
        list.add("zac");
        service.getOneV3(list);
    }

    @Test
    public void testMethodV2() throws NoSuchMethodException {

        PersonService service = new PersonService();
        service.getOneV2(-1, null);
    }

    @Test
    public void testMethodV1() {

        PersonService service = new PersonService();
        service.getOneV1(-1, null);
    }

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

    public class PersonService {

        public Person getOneV3(List<@Valid @Email String> emails) throws NoSuchMethodException {
            // 校验逻辑
            Method currMethod = this.getClass().getMethod("getOneV3", List.class);
            Set<ConstraintViolation<PersonService>> validResult =
                    ValidatorUtil.obtainExecutableValidator()
                            .validateParameters(this, currMethod, new Object[] {emails});
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
         *    3. 代码侵入性强
         * </pre>
         *
         * @param id
         * @param name
         * @return
         */
        public Person getOneV2(@NotNull @Min(1) Integer id, @NotNull String name)
                throws NoSuchMethodException {
            // 校验逻辑
            Method currMethod = this.getClass().getMethod("getOneV2", Integer.class, String.class);
            Set<ConstraintViolation<PersonService>> validResult =
                    ValidatorUtil.obtainExecutableValidator()
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
}
