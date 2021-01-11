package cn.edu.ntu.javaee.springboot.jdbc.dao;

import cn.edu.ntu.javaee.springboot.jdbc.model.po.Department;

import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project integration <br>
 */
public interface IDeptDAO {
  /**
   * Get all departments.
   *
   * @return
   */
  List<Department> getALlDepartments();
}
