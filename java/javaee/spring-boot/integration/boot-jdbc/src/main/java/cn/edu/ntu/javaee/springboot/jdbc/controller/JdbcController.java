package cn.edu.ntu.javaee.springboot.jdbc.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-05-03 20:28 <br>
 */
@RestController
public class JdbcController {
  @Resource JdbcTemplate jdbcTemplate;

  @GetMapping("/query")
  public Map<String, Object> map() {
    List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM db_dept");
    return list.get(0);
  }
}
