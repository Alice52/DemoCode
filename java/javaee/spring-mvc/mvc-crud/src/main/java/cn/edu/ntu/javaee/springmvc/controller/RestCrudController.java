package cn.edu.ntu.javaee.springmvc.controller;

import cn.edu.ntu.javaee.springmvc.dao.DepartmentDao;
import cn.edu.ntu.javaee.springmvc.dao.EmployeeDao;
import cn.edu.ntu.javaee.springmvc.model.Department;
import cn.edu.ntu.javaee.springmvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/** @author zack */
@Controller
public class RestCrudController {

    @Resource private EmployeeDao employeeDao;

    @Resource private DepartmentDao departmentDao;

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id") Integer id, Map<String, Object> map) {
        // 查询要修改的员工信息
        Employee employee = employeeDao.get(id);
        map.put("employee", employee);

        // 页面中显示部门下拉列表的数据
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);

        // 页面中生成性别单选框的数据
        Map<String, String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);

        // 去往修改页面
        return "input";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        // 删除员工
        employeeDao.delete(id);
        // 重定向到列表
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        // 添加员工
        employeeDao.save(employee);
        // 回到列表页面 :重定向到显示所有员工信息列表的请求.

        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String toAddPage(Map<String, Object> map) {
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);

        // 2. 构造页面中生成单选框的数据
        Map<String, String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);

        // 3. 设置页面中要回显的数据
        map.put("employee", new Employee());

        return "input";
    }

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String listAllEmps(Map<String, Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);

        return "list";
    }
}
