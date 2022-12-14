package cn.edu.ntu.java.javase.interview.abc.v2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-12-08 4:42 PM <br>
 * @project javase <br>
 */
@Slf4j
public class ABCJoin {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new printABC(null), "A");
            Thread t2 = new Thread(new printABC(t1), "B");
            Thread t3 = new Thread(new printABC(t2), "C");

            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(10);
            // 这里是要保证只有t1、t2、t3为一组，进行执行才能保证t1->t2->t3的执行顺序
        }
    }

    static class printABC implements Runnable {
        private Thread beforeThread;

        public printABC(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }

        @SneakyThrows
        @Override
        public void run() {
            if (beforeThread != null) {
                beforeThread.join();
                log.info(Thread.currentThread().getName());
            } else {
                log.info(Thread.currentThread().getName());
            }
        }
    }
}
