package cn.edu.ntu.jdbc.sample;

import cn.edu.ntu.jdbc.sample.entity.SerialModel;
import cn.edu.ntu.jdbc.sample.generics.dao.SerialDAO;
import cn.edu.ntu.jdbc.sample.generics.dao.impl.SerialDAOImpl;
import cn.edu.ntu.jdbc.sample.utils.JDBCUtils;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-04-23 20:12 <br>
 */
public class SerialDAOImplTest {
    private SerialDAO dao = new SerialDAOImpl();

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            SerialModel cust = new SerialModel(100L, IdUtil.fastSimpleUUID());
            dao.insert(conn, cust);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testDeleteById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            dao.deleteById(conn, 1);

            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testUpdateConnectionCustomer() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            SerialModel cust = new SerialModel(100L, IdUtil.objectId());
            dao.update(conn, cust);

            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testGetCustomerById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            SerialModel cust = dao.getCustomerById(conn, 100);
            System.out.println(cust);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testGetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            List<SerialModel> list = dao.getAll(conn);
            list.forEach(System.out::println);

            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testGetCount() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            Long count = dao.getCount(conn);

            System.out.println("表中的记录数为：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}
