package com.augmentum.springdata;

import com.augmentum.springdata.repository.PersonRepository;
import com.augmentum.springdata.entities.Person;
import com.augmentum.springdata.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zack
 * @create 2019-08-10 23:11
 * @function the class is to test instance.
 */
public class TestSpringData {

    private static final String APPLICATION_CONTEXT_PATH= "applicationContext.xml";
    private static final Logger LOG = LoggerFactory.getLogger(TestSpringData.class);
    private ApplicationContext ctx;
    private PersonRepository personRepository = null;
    private PersonService personService;


    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_PATH);
        personRepository = ctx.getBean(PersonRepository.class);
        personService= ctx.getBean(PersonService.class);
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = ctx.getBean(DataSource.class);
        LOG.info("get dataSource success: "+ dataSource);
    }


    @Test
    public void testHelloWorldSpringData() {
        LOG.info("personRepository name: " + personRepository.getClass().getName());
        Person person = personRepository.getByLastName("AA");
        LOG.info("person: " + person);
    }

    @Test
    public void testPersonRepositoryImplMethod(){
        // PersonRepositoryImpl can do not implements personRepository.
        // If personRepository extends PersonDao and PersonRepositoryImpl implements PersonDao,
        // personRepository can use the method interface in PersonDao.
        personRepository.test();
    }

    @Test
    // config application entityManagerFactory -- jpaPropertyMap -- property can make it a true batch.
    public void testTransactionSaveAll(){
        List<Person> persons = new ArrayList<>();

        for(int i = 'a'; i <= 'z'; i++){
            Person person = new Person();
            person.setAddressId(i + 1);
            person.setBirthday(new Date());
            person.setEmail((char)i + "" + (char)i + "@qq.com");
            person.setLastName((char)i + "" + (char)i);

            persons.add(person);
        }

        personService.savePersons(persons);
    }

    @Test
    public void testTransactionUpdate(){
        personService.updatePersonEmail("mmmm@atguigu.com", 1);
    }

    @Test
    public void testPagingAndSortingRepository(){
        //pageNo 从 0 开始.
        int pageNo = 6 - 1;
        int pageSize = 5;
        //Pageable 接口通常使用的其 PageRequest 实现类. 其中封装了需要分页的信息
        //排序相关的. Sort 封装了排序的信息
        //Order 是具体针对于某一个属性进行升序还是降序.
        Order order1 = new Order(Direction.DESC, "id");
        Order order2 = new Order(Direction.ASC, "email");
        Sort sort = Sort.by(order1, order2);

        PageRequest pageable =  PageRequest.of(pageNo, pageSize, sort);
        Page<Person> page = personRepository.findAll(pageable);

        System.out.println("总记录数: " + page.getTotalElements());
        System.out.println("当前第几页: " + (page.getNumber() + 1));
        System.out.println("总页数: " + page.getTotalPages());
        System.out.println("当前页面的 List: " + page.getContent());
        System.out.println("当前页面的记录数: " + page.getNumberOfElements());
    }
}
