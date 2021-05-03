package cn.edu.ntu.mybatis;

import cn.edu.ntu.mybatis.common.entity.Department;
import cn.edu.ntu.mybatis.sample.DepartmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zack <br>
 * @create 2020-06-15 21:43 <br>
 * @project mybatis <br>
 */
@Slf4j
public class DepartmentTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Department department =
                    openSession.selectOne(
                            "cn.edu.ntu.mybatis.sample.DepartmentMapper.getDeptById", 1);
            log.info(String.valueOf(department));
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            Department department = mapper.getDeptByIdStep(1);
            log.info(String.valueOf(mapper.getClass()));
            log.info(String.valueOf(department));
        } finally {
            openSession.close();
        }
    }
}
