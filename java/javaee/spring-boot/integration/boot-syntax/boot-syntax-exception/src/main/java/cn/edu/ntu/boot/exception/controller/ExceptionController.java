package cn.edu.ntu.boot.exception.controller;

import cn.edu.ntu.boot.exception.exception.UserNotExistException;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.BadStringOperationException;
import java.util.InvalidPropertiesFormatException;

/**
 * @author zack <br>
 * @create 2020-04-27 20:30 <br>
 */
@RestController
public class ExceptionController {

    @GetMapping(value = "/userNotExistException")
    public JsonObject userNotExistException() {
        throw new UserNotExistException();
    }

    @GetMapping(value = "/runtimeException")
    public ErrorResponse runtimeException() {
        throw new RuntimeException();
    }

    @GetMapping(value = "/exception")
    public ErrorResponse exception() throws Exception {
        throw new Exception();
    }

    @GetMapping(value = "/bad-string-operation-exception")
    public Object badStringOperationException() throws Exception {
        throw new BadStringOperationException("");
    }

    @GetMapping(value = "/invalid-properties-format-exception")
    public Object invalidPropertiesFormatException() throws Exception {
        throw new InvalidPropertiesFormatException("");
    }

    @GetMapping("/lombok-sneaky-throws")
    public String sneaky() {
        sneakyLogic();
        return "PONG";
    }

    @SneakyThrows
    private void sneakyLogic() {
        throw new Exception("sad");
    }
}
