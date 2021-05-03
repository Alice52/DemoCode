package cn.edu.ntu.jdbc.sample;

import com.mysql.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zack <br>
 * @create 2020-04-21 20:28 <br>
 */
@Slf4j
public class ConnectionTest {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Yu**?";
    private static final String CONNECTION_URL = "jdbc:mysql://101.132.45.28:3306/tutorials";

    @Test
    public void testConnectionByDriver() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        Properties info = new Properties();
        info.setProperty("user", USERNAME);
        info.setProperty("password", PASSWORD);

        Connection conn = driver.connect(CONNECTION_URL, info);
        log.info(conn.toString());

        conn.close();
    }

    @Test
    public void testConnectionByReflect() throws Exception {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        Properties info = new Properties();
        info.setProperty("user", USERNAME);
        info.setProperty("password", PASSWORD);

        Connection conn = driver.connect(CONNECTION_URL, info);
        log.info(conn.toString());

        conn.close();
    }

    @Test
    public void testConnectionByDriverManager0() throws Exception {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);

        Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

        log.info(conn.toString());
        conn.close();
    }

    @Test
    public void testConnectionByDriverManager() throws SQLException {
        Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

        log.info(conn.toString());
        conn.close();
    }

    @Test
    public void testConnectionByDriverManagerAndConfig() throws Exception {

        InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        properties.load(in);

        Connection conn =
                DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password"));

        log.info(conn.toString());
        conn.close();
    }
}
