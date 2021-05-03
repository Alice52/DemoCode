package cn.edu.ntu.javaee.springboot.validation.service.impl;

import cn.edu.ntu.javaee.springboot.validation.vo.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2020-08-02 14:18 <br>
 * @project validation <br>
 */
@Service
@Validated
public class AopService {
    private static final Logger LOG = LoggerFactory.getLogger(AopService.class);

    public void addDepartment(@Valid Department department) {
        LOG.info("add first method");
        validate(null);
    }

    public void validate(@NotNull String name) {
        LOG.info("add first method");
    }
}
