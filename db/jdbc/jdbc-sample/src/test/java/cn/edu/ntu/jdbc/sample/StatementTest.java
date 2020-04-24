package cn.edu.ntu.jdbc.sample;

import cn.edu.ntu.jdbc.sample.entity.SerialModel;
import cn.edu.ntu.jdbc.sample.utils.QueryUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * @author zack <br>
 * @create 2020-04-22 11:40 <br>
 */
@Slf4j
public class StatementTest {

  private Connection conn;

  @Before
  public void initConnection() throws Exception {

    InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("db.properties");
    Properties properties = new Properties();

    properties.load(in);

    this.conn =
        DriverManager.getConnection(
            properties.getProperty("url"),
            properties.getProperty("user"),
            properties.getProperty("password"));

    log.info(conn.toString());
  }

  @After
  public void closeConnection() throws Exception {
    this.conn.close();
  }

  @Test
  public void testStatement() throws SQLException {

    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM cloud_payment");

    // contain database schema info
    log.info(resultSet.getMetaData().toString());

    while (resultSet.next()) {
      log.info(resultSet.getLong("id") + "");
      log.info(resultSet.getString("serial"));
    }
  }

  @Test
  public void testQueryUtil() throws Exception {

    List<SerialModel> query = QueryUtil.getForList(SerialModel.class, "SELECT * FROM cloud_payment where id = ?", 1);
    query.stream().forEach(System.out::println);
  }
}
