package cn.edu.ntu.mybatis;

import cn.edu.ntu.mybatis.common.entity.Department;
import cn.edu.ntu.mybatis.common.entity.Employee;
import cn.edu.ntu.mybatis.sample.DepartmentMapper;
import cn.edu.ntu.mybatis.sample.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author zack <br>
 * @create 2020-06-14 19:46 <br>
 * @project mybatis <br>
 */
@Slf4j
public class MyBatisTest {

  public SqlSessionFactory getSqlSessionFactory() throws IOException {
    String resource = "mybatis.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    return new SqlSessionFactoryBuilder().build(inputStream);
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
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

    SqlSession openSession = sqlSessionFactory.openSession();
    try {
      Employee employee =
          openSession.selectOne("cn.edu.ntu.mybatis.sample.EmployeeMapper.getEmpById", 1);
      log.info(String.valueOf(employee));
    } finally {
      openSession.close();
    }
  }

  @Test
  public void test01() throws IOException {
    // 1. 获取sqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    // 2. 获取sqlSession对象
    SqlSession openSession = sqlSessionFactory.openSession();
    try {
      // 3. 获取接口的实现类对象
      // 会为接口自动的创建一个代理对象, 代理对象去执行增删改查方法
      EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
      Employee employee = mapper.getEmpById(1);
      log.info(String.valueOf(mapper.getClass()));
      log.info(String.valueOf(employee));
    } finally {
      openSession.close();
    }
  }

  @Test
  public void testGetByName() throws IOException {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    try {
      EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
      Employee employee = mapper.getEmpByName("zack");
      log.info(String.valueOf(mapper.getClass()));
      log.info(String.valueOf(employee));
    } finally {
      openSession.close();
    }
  }

  @Test
  public void testReturnMap() throws IOException {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    try {
      EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
      Map<String, Employee> employees = mapper.getEmpByLastNameLikeReturnMap("zack");
      Stream.of(employees).forEach(employee -> log.info(String.valueOf(employee)));

    } finally {
      openSession.close();
    }
  }

  @Test
  public void test02() throws IOException {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

    SqlSession openSession = sqlSessionFactory.openSession();
    try {
      EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
      Map<String, Object> empByIdReturnMap = mapper.getEmpByIdReturnMap(1);
      log.info(String.valueOf(mapper.getClass()));
      Stream.of(empByIdReturnMap).forEach(employee -> log.info(String.valueOf(employee)));
    } finally {
      openSession.close();
    }
  }
}
