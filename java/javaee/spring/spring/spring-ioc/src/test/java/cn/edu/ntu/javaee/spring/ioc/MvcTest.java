package cn.edu.ntu.javaee.spring.ioc;

import cn.edu.ntu.javaee.spring.common.constants.Constants;
import cn.edu.ntu.javaee.spring.mvc.controller.PersonController;
import cn.edu.ntu.javaee.spring.mvc.repository.PersonRepository;
import cn.edu.ntu.javaee.spring.mvc.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zack
 * @create 2019-10-27 22:50
 * @function test function of MVC
 */
public class MvcTest {

  private ApplicationContext ctx;
  private static final Logger LOG = LoggerFactory.getLogger(MvcTest.class);

  @Before
  public void init() {
    ctx = new ClassPathXmlApplicationContext(Constants.APPLICATION_CONTEXT_MVC_XML_PATH);
  }

  @Test
  public void testAnnotationBean() {
    PersonController controller = ctx.getBean("personController", PersonController.class);
    LOG.info("Get personController: {} from IOC container success.", controller);

    PersonService service = ctx.getBean("personServiceImpl", PersonService.class);
    LOG.info("Get PersonService: {} from IOC container success.", service);

    PersonRepository repository =
        ctx.getBean("personRepositoryMybatisImpl", PersonRepository.class);
    LOG.info("Get PersonRepository: {} from IOC container success.", repository);
  }

  @Test
  public void testMVCProcessor() {
    PersonController controller = ctx.getBean("personController", PersonController.class);
    LOG.info("Get personController: {} from IOC container success.", controller);
    controller.register();
  }
}
