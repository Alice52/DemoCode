package cn.edu.ntu.jdbc.sample.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zack <br>
 * @create 2020-04-22 13:26 <br>
 */
@Slf4j
public final class QueryUtil {

    private static Connection conn;

    public static void initConnection() throws Exception {
        InputStream in = QueryUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        properties.load(in);

        conn =
                DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password"));

        log.info(conn.toString());
    }

    @After
    public static void closeConnection() throws Exception {
        conn.close();
    }

    public static <T> List<T> query(String sql, Class<T> clazz) throws Exception {
        List<T> list = new ArrayList<>();
        initConnection();

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();

        int columnCount = rsmd.getColumnCount();

        while (resultSet.next()) {
            T t = clazz.newInstance();
            for (int i = 0; i < columnCount; i++) {
                String columnName = rsmd.getColumnLabel(i + 1);
                Object columnVal = resultSet.getObject(columnName);

                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnVal);
            }
            list.add(t);
        }

        return list;
    }

    /**
     * ERROR: try to retived T type
     *
     * @param sql
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> query(String sql) throws Exception {

        // get T type for create instance
        Class<T> type;
        Class clazz = QueryUtil.class;
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        // 获取具体的泛型的类型
        type = (Class<T>) types[0];

        List<T> list = new ArrayList<>();
        initConnection();

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();

        int columnCount = rsmd.getColumnCount();

        while (resultSet.next()) {
            T t = type.newInstance();
            for (int i = 0; i < columnCount; i++) {
                String columnName = rsmd.getColumnLabel(i + 1);
                Object columnVal = resultSet.getObject(columnName);

                Field field = type.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnVal);
            }
            list.add(t);
        }

        return list;
    }

    public static <T> List<T> getForList(Class<T> clazz, String sql, Object... args)
            throws Exception {
        initConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            // 创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
