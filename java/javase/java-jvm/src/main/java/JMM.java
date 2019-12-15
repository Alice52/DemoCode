import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author zack
 * @create 2019-12-15 21:10
 * @function
 */
public class JMM {
  private static final Logger LOG = LoggerFactory.getLogger(JMM.class);

  public static void main(String[] args) {
    TResource resource = new TResource();

    new Thread(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(3);
                  resource.addTo100();
              } catch (InterruptedException e) {
                LOG.info("occurs exception: {}", e);
              }
            },
            "AA")
        .start();

    // notice
    while (resource.getNumber() == 10) {
      // if number is 10, will in while; else out while
      // [volatile]need someone tell main thread, the value of number has changed to 100
    }

    LOG.info(
        "{}, out while and number is {}", Thread.currentThread().getName(), resource.getNumber());
  }
}

class TResource {
  private volatile int number = 10;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void addTo100() {
    number = 100;
  }
}
