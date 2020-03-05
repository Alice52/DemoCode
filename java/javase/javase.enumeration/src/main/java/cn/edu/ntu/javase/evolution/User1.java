package cn.edu.ntu.javase.evolution;

import cn.edu.ntu.javase.evolution.constants.UserStatusConstants;
import cn.edu.ntu.javase.evolution.enumeration.UserStatus;
import org.junit.Test;

/**
 * In this class, status is int, but expected 0, 1;
 * so, should know UserStatusConstants to ensure correct,
 * so, optimize with setStatus and getStatus to make sure User1 status is correct.
 *
 * @author zack <br>
 * @create 2020-01-31 15:51 <br>
 */
public class User1 {
  private String name;
  private int status;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Test
  public void testUser2() {
    User1 user = new User1();
    user.setName("zack");
    // status should by 0, 1.
    user.setStatus(UserStatusConstants.ENABLE);
    // 5 is invalid status, it should be avoid.
    user.setStatus(5);
  }
}
