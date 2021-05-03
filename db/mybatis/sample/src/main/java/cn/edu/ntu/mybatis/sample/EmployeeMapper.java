package cn.edu.ntu.mybatis.sample;

import cn.edu.ntu.mybatis.common.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-06-14 19:43 <br>
 * @project mybatis <br>
 */
public interface EmployeeMapper {

    /**
     * Get by deptId.
     *
     * @param id
     * @return
     */
    Employee getEmpByDeptId(@Param("deptId") Integer id);

    /**
     * Get by id.
     *
     * @param id
     * @return
     */
    Employee getEmpById(@Param("id") Integer id);

    /**
     * Get by like name.
     *
     * @param name
     * @return
     */
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

    /**
     * Return Map: <br>
     * - values [1, zack, 1, zzhang_xz@163.com] <br>
     * - keys: [gender, name, id, email] <br>
     *
     * @param id
     * @return
     */
    Map<String, Object> getEmpByIdReturnMap(Integer id);

    /**
     * Return List.
     *
     * @param lastName
     * @return
     */
    List<Employee> getEmpsByLastNameLike(@Param("lastName") String lastName);

    /**
     * Get by map.
     *
     * @param map
     * @return
     */
    Employee getEmpByMap(Map<String, Object> map);

    /**
     * insert.
     *
     * @param employee
     */
    void addEmp(Employee employee);

    /**
     * Update.
     *
     * @param employee
     */
    void updateEmp(Employee employee);

    /**
     * Delete .
     *
     * @param id
     */
    void deleteEmpById(Integer id);

    /**
     * Get all employee.
     *
     * @param employeeId
     * @return
     */
    Employee getEmpAndDept(@Param("id") Integer employeeId);
}
