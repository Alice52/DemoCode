package cn.edu.ntu.javaee.springboot.jdbc.dao.impl;

import cn.edu.ntu.javaee.springboot.jdbc.dao.BaseDAO;
import cn.edu.ntu.javaee.springboot.jdbc.dao.IDeptDAO;
import cn.edu.ntu.javaee.springboot.jdbc.model.po.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * https://github.com/Alice52/tutorials-sample/tree/master/db/jdbc/jdbc-sample for detail
 *
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project integration <br>
 */
@Service
public class DeptDAOImpl extends BaseDAO<Department> implements IDeptDAO {
    @Override
    public List<Department> getALlDepartments() {

        return this.getForList(null, null);
    }
}
