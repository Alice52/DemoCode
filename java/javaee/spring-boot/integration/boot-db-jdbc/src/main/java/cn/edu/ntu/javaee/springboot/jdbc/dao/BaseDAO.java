package cn.edu.ntu.javaee.springboot.jdbc.dao;

import com.mysql.jdbc.Connection;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project integration <br>
 */
public abstract class BaseDAO<T> {

  private Class<T> clazz = null;

  {
    // 获取当前 BaseDAO 的子类继承的父类时的泛型: this is subClass
    Type genericSuperclass = this.getClass().getGenericSuperclass();
    ParameterizedType paramType = (ParameterizedType) genericSuperclass;

    // 获取了父类的泛型参数
    Type[] typeArguments = paramType.getActualTypeArguments();
    // 泛型的第一个参数
    clazz = (Class<T>) typeArguments[0];
  }

  /**
   * 通用的查询操作，用于返回数据表中的多条记录构成的集合
   *
   * @param conn
   * @param sql
   * @param args
   * @return
   */
  @SneakyThrows
  public List<T> getForList(Connection conn, String sql, Object... args) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    ps = conn.prepareStatement(sql);
    for (int i = 0; i < args.length; i++) {
      ps.setObject(i + 1, args[i]);
    }

    rs = ps.executeQuery();
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    ArrayList<T> list = new ArrayList<>();
    while (rs.next()) {
      T t = clazz.newInstance();
      for (int i = 0; i < columnCount; i++) {
        Object columnValue = rs.getObject(i + 1);
        String columnLabel = rsmd.getColumnLabel(i + 1);
        Field field = clazz.getDeclaredField(columnLabel);
        field.setAccessible(true);
        field.set(t, columnValue);
      }
      list.add(t);
    }

    return list;
  }
}
