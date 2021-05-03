import com.augmentum.jpa.entity.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * @author zack
 * @create 2019-07-09 22:10
 * @function
 */
public class TestJPA {

    private static final String persistenceUnitName = "NewPersistenceUnit";
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Before
    public void init() {
        // 1.创建 EntityManagerFactory
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        // 2.创建 EntityManager
        entityManager = entityManagerFactory.createEntityManager();
        // 3.开启事务
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @After
    public void destroy() {
        // 5.提交事务
        transaction.commit();
        // 6. 关闭 EntityManager
        entityManager.close();
        // 7. 关闭 EntityManagerFactory
        entityManagerFactory.close();
    }

    @Test
    public void testUTCAnnotation() {
        // 4.进行持久化操作
        Customer customer = new Customer();
        customer.setAge(12);
        customer.setBirthDay(new Date());
        customer.setLastName("zack");
        entityManager.persist(customer);
    }
}
