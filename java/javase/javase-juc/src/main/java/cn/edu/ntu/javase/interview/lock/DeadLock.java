package cn.edu.ntu.javase.interview.lock;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * jps -l <br>
 * jstack PID: Found 1 deadlock.
 *
 * @author zack <br>
 * @create 2021-03-01 16:02 <br>
 * @project javase <br>
 */
@Slf4j
public class DeadLock {

  public static void main(String[] args) {
    DeadResource deadLock = new DeadResource("1", "2");
    new Thread(() -> deadLock.addWithR1Lock(), "R1").start();
    new Thread(() -> deadLock.addWithR2Lock(), "R2").start();
  }

  static class DeadResource {

    String r1Lock;
    String r2Lock;

    public DeadResource(String r1, String r2) {
      this.r1Lock = r1;
      this.r2Lock = r2;
    }

    @SneakyThrows
    public void addWithR1Lock() {
      synchronized (r1Lock) {

        // 为了让 addWithR2Lock 获取 r2Lock 锁
        TimeUnit.SECONDS.sleep(2);

        synchronized (r2Lock) {
          log.info("execute method of addWithR1Lock.");
        }
      }
    }

    @SneakyThrows
    public void addWithR2Lock() {
      synchronized (r2Lock) {
        // 为了让 addWithR1Lock 获取 r2Lock 锁
        TimeUnit.SECONDS.sleep(2);
        synchronized (r1Lock) {
          log.info("execute method of addWithR2Lock.");
        }
      }
    }
  }
}
