package cn.edu.ntu.javaee.springboot.validation.controller;

import cn.edu.ntu.javaee.springboot.validation.common.ErrorResponse;
import cn.edu.ntu.javaee.springboot.validation.service.DepartmentService;
import cn.edu.ntu.javaee.springboot.validation.vo.Department;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Do not do any validation for parameters, and do it in service.
 *
 * @author zack <br>
 * @create 2020-08-01 18:39 <br>
 * @project validation <br>
 */
@ApiResponses({
    @ApiResponse(code = 400, message = "Internal Error", response = ErrorResponse.class)
})
@Api
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource private DepartmentService departmentService;

    @PostMapping
    public void add(@RequestBody Department department) {

        departmentService.addDepartment(department);
    }
}
