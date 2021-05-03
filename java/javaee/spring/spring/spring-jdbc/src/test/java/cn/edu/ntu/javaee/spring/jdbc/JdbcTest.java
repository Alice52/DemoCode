package cn.edu.ntu.javaee.spring.jdbc;

import cn.edu.ntu.javaee.spring.common.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zack
 * @create 2019-10-31 21:27
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class JdbcTest {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcTest.class);
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testUpdate() {
        String sql =
                "insert into demo_user(name, age, birthDay, email, descripttion, create_time, salary) values(?,?,?,?,?,?, ?)";
        jdbcTemplate.update(
                sql,
                "zack" + UUID.randomUUID().toString(),
                20,
                new Date(),
                "zzhang_xz@163.com",
                "lazy",
                new Date(),
                100.00);
    }

    @Test
    public void testUpdate2() {
        String sql =
                "insert into demo_user(name, age, birthDay, email, salary) values(:name,:age,:birthDay,:email, :salary)";

        Person person = new Person();
        person.setAge(20);
        person.setBirthDay(new Date());
        person.setEmail("zzhang_xz@163.com");
        person.setName("zack" + UUID.randomUUID().toString());
        person.setGender(true);
        person.setSalary(100.00);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(person);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    /** this operation is no transaction */
    @Test
    public void testBatchUpdate() {
        String sql =
                "insert into demo_user(name, age, birthDay, email, descripttion, create_time, salary) values(?,?,?,?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(
                new Object[] {
                    "zack" + UUID.randomUUID().toString(),
                    20,
                    new Date(),
                    "zzhang_xz@163.com",
                    "lazy",
                    new Date(),
                    100.00
                });
        batchArgs.add(
                new Object[] {
                    "zack" + UUID.randomUUID().toString(),
                    20,
                    new Date(),
                    "zzhang_xz@163.com",
                    "lazy",
                    new Date(),
                    100.00
                });

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Test
    public void testQuery() {
        // this place should not use *
        String sql = "select * from demo_user";
        RowMapper<Person> personRowMapper = new BeanPropertyRowMapper<>(Person.class);

        List<Person> person = jdbcTemplate.query(sql, personRowMapper);
        LOG.info("Get person {} from db success.", person);
    }
}
