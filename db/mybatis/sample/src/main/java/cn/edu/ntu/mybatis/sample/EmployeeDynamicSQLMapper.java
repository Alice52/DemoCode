package cn.edu.ntu.mybatis.sample;

import cn.edu.ntu.mybatis.common.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zack <br>
 * @create 2020-06-16 21:07 <br>
 * @project mybatis <br>
 */
public interface EmployeeDynamicSQLMapper {

    List<Employee> getEmpsTestInnerParameter(Employee employee);

    /**
     * Get by condition.
     *
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionIf(Employee employee);

    List<Employee> getEmpsByConditionTrim(Employee employee);

    List<Employee> getEmpsByConditionChoose(Employee employee);

    void updateEmp(Employee employee);

    /**
     * 查询员工 id 在给定集合中的
     *
     * @param ids
     * @return
     */
    List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    /**
     * Insert .
     *
     * @param emps
     */
    void addEmps1(@Param("emps") List<Employee> emps);
}
