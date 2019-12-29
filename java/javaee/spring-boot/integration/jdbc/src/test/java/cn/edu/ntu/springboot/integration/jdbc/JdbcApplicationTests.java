package cn.edu.ntu.springboot.integration.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JdbcApplication.class)
@WebAppConfiguration
public class JdbcApplicationTests {

  private static final Logger LOG = LoggerFactory.getLogger(JdbcApplicationTests.class);

  @Autowired DataSource dataSource;
  @Autowired JdbcTemplate jdbcTemplate;

  @Test
  public void testDataSource() throws SQLException {

    Connection connection = dataSource.getConnection();
    LOG.info("DataSource: {}, and Connection: {}", dataSource, connection);
  }

  @Test
  public void testJdbcTemplate() {

    LOG.info("JdbcTemplate: {}", jdbcTemplate);
  }
}
