package cn.edu.ntu.mybatis.sample;

import cn.edu.ntu.mybatis.common.entity.Department;
import org.apache.ibatis.annotations.Param;

/**
 * @author zack <br>
 * @create 2020-06-15 21:27 <br>
 * @project mybatis <br>
 */
public interface DepartmentMapper {

  /**
   * Get by id.
   *
   * @param id
   * @return
   */
  Department getDeptById(@Param("id") Integer id);

  /**
   * Get step.
   *
   * @param id
   * @return
   */
  Department getDeptByIdStep(@Param("id") Integer id);
}
