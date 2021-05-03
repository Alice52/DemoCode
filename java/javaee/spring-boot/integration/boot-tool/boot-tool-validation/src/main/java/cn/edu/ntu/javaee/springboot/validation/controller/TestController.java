package cn.edu.ntu.javaee.springboot.validation.controller;

import cn.edu.ntu.javaee.springboot.validation.service.ITestService;
import cn.edu.ntu.javaee.springboot.validation.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;
import java.util.*;

/**
 * @author zack <br>
 * @create 2020-07-27 21:56 <br>
 * @project jsr303 <br>
 */
@Api
@RestController
@Validated
public class TestController {

    @Resource ITestService testService;

    @GetMapping("/validate")
    public String validate(@NotBlank @PathParam("email") String email) {

        // this validation is worked.
        email = "zzhang_xz163.com";

        return testService.validate(email);
    }

    @GetMapping("/validate2")
    public String validate2(@NotBlank @PathParam("email") String email) {

        // this validation is not worked, due to the @Email annotation do not work for it.
        email = null;
        return testService.validate(email);
    }

    /**
     * this validation of <code>@Valid</code> is required.
     *
     * <p>otherwise the validation is not worked.
     *
     * @param userVO
     * @return
     */
    @GetMapping("/register")
    public UserVO register(@Valid UserVO userVO) {

        return testService.register(userVO);
    }

    /**
     * this code <code>userVO.setAge(-12);</code> will lead to register validation failed, which is
     * expected and prove service validation is worked.
     *
     * @param userVO
     * @return
     */
    @GetMapping("/register2")
    public UserVO register2(@Valid UserVO userVO) {

        userVO.setAge(-12);
        return testService.register(userVO);
    }

    @GetMapping("/validateBetweenService")
    public String validateBetweenService(@RequestParam("email") String email) throws Exception {

        return testService.validateBetweenService(email);
    }

    /**
     * this sample is explain for validated, it should has itself BindingResult
     *
     * @param userVO
     * @param result
     * @param user
     * @param result2
     * @return
     */
    @GetMapping("/validated")
    public Object validated(
            @Validated UserVO userVO,
            BindingResult result,
            @Validated UserVO user,
            BindingResult result2) {

        List list = new ArrayList();
        Optional.ofNullable(result)
                .filter(x -> x.hasErrors())
                .ifPresent(
                        x -> {
                            x.getFieldErrors()
                                    .forEach(
                                            y -> {
                                                Map map = new HashMap<>(4);
                                                map.put("message", y.getDefaultMessage());
                                                map.put("filed", y.getField());
                                                map.put("rejectValue", y.getRejectedValue());
                                                list.add(map);
                                            });
                        });

        return list;
    }

    @GetMapping("/hello")
    public Object hello(
            @RequestParam(value = "age") Integer age, @RequestParam(value = "email") String email) {

        return testService.hello(age, email);
    }
}
