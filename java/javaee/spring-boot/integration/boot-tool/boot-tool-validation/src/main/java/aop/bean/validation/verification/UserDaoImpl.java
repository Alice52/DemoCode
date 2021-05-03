package aop.bean.validation.verification;

import aop.bean.validation.verification.interfaces.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUser(User user) throws CustomException {
        // TODO .. add user
        System.out.println(
                "User "
                        + user.getFirstName()
                        + " "
                        + user.getLastName()
                        + " has been added successfully!");
    }
}
