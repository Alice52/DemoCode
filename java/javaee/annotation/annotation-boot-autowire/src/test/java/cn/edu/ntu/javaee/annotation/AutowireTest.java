package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.common.model.Dog;
import cn.edu.ntu.javaee.annotation.controller.HelloController;
import cn.edu.ntu.javaee.annotation.controller.JsrController;
import cn.edu.ntu.javaee.annotation.model.Animal;
import cn.edu.ntu.javaee.annotation.model.Animal2;
import cn.edu.ntu.javaee.annotation.model.Animal3;
import cn.edu.ntu.javaee.annotation.service.HelloService;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zack <br>
 * @create 2020-04-30 17:05 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AutowireTest {

  AnnotationConfigApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(AutowireApplication.class);

  @Autowired private HelloService helloService;

  @Test
  public void testAutowire() {
    HelloController bean1 = applicationContext.getBean(HelloController.class);
    log.info(String.valueOf(bean1.helloService));
    HelloService bean = (HelloService) applicationContext.getBean("helloService2");

    Assert.isTrue(bean == bean1.helloService);
    Assert.isFalse(helloService == bean1.helloService);
  }

  @Test
  public void testJsrResource() {
    JsrController bean1 = applicationContext.getBean(JsrController.class);
    log.info(String.valueOf(bean1.helloService));
    HelloService bean = (HelloService) applicationContext.getBean("helloService");

    Assert.isTrue(bean == bean1.helloService);
    Assert.isFalse(helloService == bean1.helloService);
  }

  @Test
  public void testMarkedInMethod() {
    Dog bean = applicationContext.getBean(Dog.class);
    Animal bean1 = applicationContext.getBean(Animal.class);
    Dog dog = bean1.getDog();
    Assert.isTrue(bean == dog);
  }

  @Test
  public void testMarkedInConstructor() {
    Dog bean = applicationContext.getBean(Dog.class);
    Animal2 bean1 = applicationContext.getBean(Animal2.class);
    Dog dog = bean1.getDog();
    Assert.isTrue(bean == dog);
  }

  @Test
  public void testMarkedInArg() {
    Dog bean = applicationContext.getBean(Dog.class);
    Animal3 bean1 = applicationContext.getBean(Animal3.class);
    Dog dog = bean1.getDog();
    Assert.isTrue(bean == dog);
  }
}
