package cn.edu.ntu.javaee.annotation.usage.spring.anno;

import cn.edu.ntu.javaee.annotation.usage.IArithmeticCalculator;
import cn.edu.ntu.javaee.annotation.usage.before.proxy.ArithmeticCalculatorImpl;
import cn.edu.ntu.javaee.annotation.usage.spring.LoggingAspect4Anno;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zack <br>
 * @create 2020-05-01 13:19 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LoggingAspect4Anno.class, ArithmeticCalculatorImpl.class})
public class AnnoAspectTest {

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
