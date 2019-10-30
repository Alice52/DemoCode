package cn.edu.ntu.spring.aop.aspect;

import cn.edu.ntu.spring.aop.before.ArithmeticCalculator;
import cn.edu.ntu.spring.constants.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zack
 * @create 2019-10-29 21:31
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class TestAspect {

  private static final Logger LOG = LoggerFactory.getLogger(TestAspect.class);
  private ApplicationContext ctx;
  @Autowired private ArithmeticCalculator arithmeticCalculator;

  @Before
  public void init() {
    ctx = new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_XML_PATH);
  }

  @Test
  public void testAspect() {

    arithmeticCalculator.add(1, 5);
  }
}
