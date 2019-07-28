import com.augmentum.jpa.JPAConnection;
import com.augmentum.jpa.relations.Customer;

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
public class GenerateTable {

    public static void main(String[] args) {

        // 1.创建 EntityManagerFactory
        String persistenceUnitName = "NewPersistenceUnit";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        // 2.创建 EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 4.进行持久化操作
        Customer jpaConnection = new Customer();
        jpaConnection.setAge(13);
        jpaConnection.setBirthDay(new Date());
        jpaConnection.setLastName("jellily");

        entityManager.persist(jpaConnection);

        // 5.提交事务
        transaction.commit();

        // 6. 关闭 EntityManager
        entityManager.close();

        // 7. 关闭 EntityManagerFactory
        entityManagerFactory.close();
    }
}
