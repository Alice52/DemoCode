package cn.edu.ntu.javaee.annotation.jdbc.service.impl;

import cn.edu.ntu.javaee.annotation.jdbc.dao.UserDao;
import cn.edu.ntu.javaee.annotation.jdbc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-04 20:40 <br>
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Resource private UserDao userDao;

    @Override
    @Transactional
    public void insertEmp() {
        userDao.insert();
        log.info("insert success");
        int i = 10 / 0;
    }
}
