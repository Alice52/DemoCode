package cn.edu.ntu.mybatis;

import cn.edu.ntu.mybatis.common.entity.Employee;
import cn.edu.ntu.mybatis.sample.EmployeeDynamicSQLMapper;
import cn.edu.ntu.mybatis.sample.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-06-16 21:12 <br>
 * @project mybatis <br>
 */
@Slf4j
public class EmployeeDynamicSQLMapperTest {

  private SqlSession openSession;
  EmployeeDynamicSQLMapper mapper;

  @Before
  public void getSqlSessionFactory() throws IOException {
    String resource = "mybatis.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    this.openSession = sqlSessionFactory.openSession();
    this.mapper = openSession.getMapper(EmployeeDynamicSQLMapper.class);
  }

  @After
  public void close() {
    openSession.commit();
    this.openSession.close();
  }

  @Test
  public void testGetByConditionIf() {

    // select * from `mybatis.employee` where id=? and name like ?
    Employee employee = new Employee();
    employee.setId(1);
    employee.setLastName("zack");
    List<Employee> emps = mapper.getEmpsByConditionIf(employee);
    emps.stream().forEach(x -> log.info(x.toString()));

    // 查询的时候如果某些条件没带可能sql拼装会有问题
    // 1. 给where后面加上1=1, 以后的条件都and xxx.
    // 2. mybatis使用where标签来将所有的查询条件包括在内, mybatis就会将where标签中拼装的sql,
    // 多出来的and或者or去掉where只会去掉第一个多出来的and或者or

    // 测试Trim
    List<Employee> emps2 = mapper.getEmpsByConditionTrim(employee);
    emps2.stream().forEach(x -> log.info(x.toString()));

    // 测试choose
    List<Employee> list = mapper.getEmpsByConditionChoose(employee);
    list.stream().forEach(x -> log.info(x.toString()));

    // 测试set标签
    mapper.updateEmp(employee);

    List<Employee> list2 = mapper.getEmpsByConditionForeach(Arrays.asList(1, 3));
    list2.stream().forEach(x -> log.info(x.toString()));
  }
}
