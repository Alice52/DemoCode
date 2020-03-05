package cn.edu.ntu.javase.evolution;

import cn.edu.ntu.javase.evolution.enumeration.UserStatus;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class used with enum UserStatus to handle specify user status, only zero or one.<br>
 *
 * @author zack <br>
 * @create 2020-01-31 15:58 <br>
 */
public class User2 {

  private static final Logger LOG = LoggerFactory.getLogger(User2.class);
  private String name;
  private UserStatus status;

  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(UserStatus status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Test
  public void testUser2() {
    User2 user = new User2();
    user.setName("zack");
    // this make sure status is 0 or 1.
    user.setStatus(UserStatus.ENABLE);
  }


}
