package hubby.typeconvert;

import hubby.typeconvert.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

/**
 * @author asd <br>
 * @create 2022-01-17 4:36 PM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@SpringBootApplication
public class TypeConvertApplication {

    public static void main(String[] args) {

        SpringApplication.run(TypeConvertApplication.class, args);
    }
}
