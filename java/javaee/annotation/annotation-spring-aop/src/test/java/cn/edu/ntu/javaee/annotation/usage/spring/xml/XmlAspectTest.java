package cn.edu.ntu.javaee.annotation.usage.spring.xml;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zack <br>
 * @create 2020-05-01 12:48 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class XmlAspectTest {

  @Autowired private IArithmeticCalculator arithmeticCalculator;

  @Test
  public void testAspect() {

    arithmeticCalculator.add(1, 5);
  }

  @Test
  @Ignore
  public void testAspectException() {

    arithmeticCalculator.div(1, 0);
  }
}
