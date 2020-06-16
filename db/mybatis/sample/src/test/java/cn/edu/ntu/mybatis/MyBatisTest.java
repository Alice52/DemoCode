package cn.edu.ntu.mybatis;

import cn.edu.ntu.mybatis.common.entity.Department;
import cn.edu.ntu.mybatis.common.entity.Employee;
import cn.edu.ntu.mybatis.sample.DepartmentMapper;
import cn.edu.ntu.mybatis.sample.EmployeeMapper;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author zack <br>
 * @create 2020-06-14 19:46 <br>
 * @project mybatis <br>
 */
@Slf4j
public class MyBatisTest {

  private SqlSession openSession;

  @Before
  public void getSqlSessionFactory() throws IOException {
    String resource = "mybatis.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    this.openSession = sqlSessionFactory.openSession();
  }

  @After
  public void close() {
    openSession.commit();
    this.openSession.close();
  }

  /**
   * 1. 根据xml配置文件（全局配置文件)创建一个SqlSessionFactory对象 有数据源一些运行环境信息 2. sql映射文件; 配置了每一个sql, 以及sql的封装规则等. 3.
   * 将sql映射文件注册在全局配置文件中 4. 写代码: 1). 根据全局配置文件得到SqlSessionFactory; 2). 使用sqlSession工厂,
   * 获取到sqlSession对象使用他来执行增删改查 一个sqlSession就是代表和数据库的一次会话, 用完关闭 3). 使用sql的唯一标志来告诉MyBatis执行哪个sql.
   * sql都是保存在sql映射文件中的.
   *
   * @throws IOException
   */
  @Test
  public void test() throws IOException {

    // 2. 获取sqlSession实例, 能直接执行已经映射的sql语句
    // sql的唯一标识: statement Unique identifier matching the statement to use.
    // 执行sql要用的参数: parameter A parameter object to pass to the statement.
    Employee employee =
        openSession.selectOne("cn.edu.ntu.mybatis.sample.EmployeeMapper.getEmpById", 1);
    log.info(String.valueOf(employee));
  }

  @Test
  public void test01() throws IOException {
    // 3. 获取接口的实现类对象 会为接口自动的创建一个代理对象, 代理对象去执行增删改查方法
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    Employee employee = mapper.getEmpById(1);
    log.info(String.valueOf(mapper.getClass()));
    log.info(String.valueOf(employee));
  }

  @Test
  public void testGetByName() throws IOException {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    Employee employee = mapper.getEmpByName("zack");
    log.info(String.valueOf(mapper.getClass()));
    log.info(String.valueOf(employee));
  }

  @Test
  public void testReturnMap() throws IOException {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    Map<String, Employee> employees = mapper.getEmpByLastNameLikeReturnMap("zack");
    Stream.of(employees).forEach(employee -> log.info(String.valueOf(employee)));
  }

  @Test
  public void test02() throws IOException {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    Map<String, Object> empByIdReturnMap = mapper.getEmpByIdReturnMap(1);

    Set<String> strings = empByIdReturnMap.keySet();
    log.info(strings.toString());

    Collection<Object> values = empByIdReturnMap.values();
    log.info(values.toString());

    log.info(String.valueOf(mapper.getClass()));
    Stream.of(empByIdReturnMap).forEach(employee -> log.info(String.valueOf(employee)));
  }

  @Test
  public void testGetsByLastNameLike() throws IOException {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    List<Employee> zack = mapper.getEmpsByLastNameLike("zack");
    zack.stream().forEach(x -> log.info(String.valueOf(x)));
  }

  @Test
  public void testGetByMap() {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

    Map<String, Object> map = MapUtil.of("id", 1);
    map.put("lastName", "zack");
    map.put("tableName", "`mybatis.employee`");

    Employee emp = mapper.getEmpByMap(map);
    log.info(emp.toString());
  }

  @Test
  public void testAddEmp() {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

    Employee employee = new Employee();
    employee.setEmail("zz@163.com");
    employee.setGender("1");
    employee.setLastName("zack02");

    mapper.addEmp(employee);
  }

  @Test
  public void testUpdateEmp() {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

    Employee employee = new Employee();
    employee.setEmail("163.com");
    employee.setGender("1");
    employee.setId(1);
    employee.setLastName("zack02");

    mapper.updateEmp(employee);
  }

  @Test
  public void testDeleteEmpById() {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    mapper.deleteEmpById(2);
  }

  @Test
  public void testGetEmpAndDept() {
    EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    Employee empAndDept = mapper.getEmpAndDept(1);
    log.info(empAndDept.toString());
  }
}
