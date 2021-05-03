package aop.bean.validation.verification;

import aop.bean.validation.verification.interfaces.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Verificator {

    public static final ApplicationContext aspectContext =
            new ClassPathXmlApplicationContext(new String[] {"aspects.xml"});
    public static final ApplicationContext appContext =
            new ClassPathXmlApplicationContext(new String[] {"context.xml"});

    public static void main(String[] args) {
        User john = (User) appContext.getBean("john");
        User peter = (User) appContext.getBean("peter");

        createUser(john);
        createUser(peter);
    }

    private static void createUser(User user) {
        UserDao userVerifier = (UserDao) aspectContext.getBean("userDao");

        try {
            userVerifier.createUser(user);
        } catch (CustomException exception) {
            System.out.println(exception.getFriendlyMessage());
        }
    }
}
