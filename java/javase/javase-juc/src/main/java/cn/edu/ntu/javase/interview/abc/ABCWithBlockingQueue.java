package cn.edu.ntu.javase.interview.abc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author asd <br>
 * @create 2021-12-09 9:32 AM <br>
 * @project javase <br>
 */
@Slf4j
public class ABCWithBlockingQueue {
    @SneakyThrows
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> System.out.println("A"));
        Thread threadB = new Thread(() -> System.out.println("B"));
        Thread threadC = new Thread(() -> System.out.println("C"));

        BlockingQueue<Thread> threads = new LinkedBlockingQueue<>();
        threads.add(threadA);
        threads.add(threadB);
        threads.add(threadC);

        for (int i = 0; i < 3; i++) {
            Thread t = threads.take();
            t.start();
        }

        TimeUnit.SECONDS.sleep(1);
    }
}
