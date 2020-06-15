package cn.edu.ntu.mybatis.sample;

import cn.edu.ntu.mybatis.common.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-06-14 19:43 <br>
 * @project mybatis <br>
 */
public interface EmployeeMapper {

  Employee getEmpByDeptId(@Param("deptId") Integer id);

  /**
   * Get by id.
   *
   * @param id
   * @return
   */
  Employee getEmpById(@Param("id") Integer id);

  @Results({@Result(property = "lastName", column = "name")})
  @Select("SELECT id, name, email, gender FROM `mybatis.employee` where name = #{name}")
  Employee getEmpByName(@Param("name") String name);

  /**
   * Entries to map, and specify key.
   *
   * @param lastName
   * @return
   */
  @MapKey("lastName")
  Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName);

  Map<String, Object> getEmpByIdReturnMap(Integer id);
}
