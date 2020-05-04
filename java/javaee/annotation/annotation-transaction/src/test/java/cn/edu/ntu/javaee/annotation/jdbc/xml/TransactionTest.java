package cn.edu.ntu.javaee.annotation.jdbc.xml;

import cn.edu.ntu.javaee.annotation.jdbc.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-04 20:48 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application.xml"})
public class TransactionTest {

  @Resource private IUserService userService;

  @Test
  public void test01() {
    userService.insertEmp();
  }
}
