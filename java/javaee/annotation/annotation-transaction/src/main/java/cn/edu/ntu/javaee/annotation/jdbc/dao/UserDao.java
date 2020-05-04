package cn.edu.ntu.javaee.annotation.jdbc.dao;

import cn.hutool.core.util.IdUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-04 20:41 <br>
 */
@Repository
public class UserDao {

  @Resource private JdbcTemplate jdbcTemplate;

  public void insert() {
    String sql = "INSERT INTO `db_emp`(name, deptId) VALUES(?,?)";
    String username = IdUtil.simpleUUID();
    jdbcTemplate.update(sql, "zack", 2);
  }
}
