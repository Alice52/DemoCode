package cn.edu.ntu.javase.thread.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;

/**
 * @author zack <br>
 * @create 2021-05-02 16:41 <br>
 * @project javase <br>
 */
@Slf4j
public class ForkJoinPoolTest {

  @SneakyThrows
  public static void main(String[] args) {

    ForkJoinPool pool = new ForkJoinPool();
    log.info("pool size: {}", pool.getPoolSize());
    log.info("pool active size: {}", pool.getActiveThreadCount());
  }
}
