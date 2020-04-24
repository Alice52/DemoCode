package cn.edu.ntu.jdbc.sample.generics.dao.impl;

import cn.edu.ntu.jdbc.sample.entity.SerialModel;
import cn.edu.ntu.jdbc.sample.generics.dao.BaseDAO;
import cn.edu.ntu.jdbc.sample.generics.dao.SerialDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-04-23 20:08 <br>
 */
public class SerialDAOImpl extends BaseDAO<SerialModel> implements SerialDAO {

  @Override
  public void insert(Connection conn, SerialModel cust) {
    String sql = "insert into cloud_payment(id, serial)values(?,?)";
    update(conn, sql, cust.getId(), cust.getSerial());
  }

  @Override
  public void deleteById(Connection conn, int id) {
    String sql = "delete from cloud_payment where id = ?";
    update(conn, sql, id);
  }

  @Override
  public void update(Connection conn, SerialModel cust) {
    String sql = "update cloud_payment set serial = ? where id = ?";
    update(conn, sql, cust.getSerial(), cust.getId());
  }

  @Override
  public SerialModel getCustomerById(Connection conn, int id) {
    String sql = "select id,serial from cloud_payment where id = ?";
    SerialModel customer = getInstance(conn, sql, id);
    return customer;
  }

  @Override
  public List<SerialModel> getAll(Connection conn) {
    String sql = "select id,serial from cloud_payment";
    List<SerialModel> list = getForList(conn, sql);
    return list;
  }

  @Override
  public Long getCount(Connection conn) {
    String sql = "select count(*) from cloud_payment";
    return getValue(conn, sql);
  }
}
