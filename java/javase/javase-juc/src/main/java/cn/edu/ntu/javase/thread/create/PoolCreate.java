package cn.edu.ntu.javase.thread.create;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Thread pool has two method to create thread:
 *
 * <pre>
 *     1. use {@link java.util.concurrent.ExecutorService }
 *     2. use {@link java.util.concurrent.ThreadPoolExecutor}
 * </pre>
 *
 * @author zack <br>
 * @create 2021-01-13<br>
 * @project javase <br>
 */
@Slf4j
public class PoolCreate {
  /**
   * Executors common methods:
   *
   * <pre>
   *     1. Executors.newFixedThreadPool(10);
   *        - 创建一个定长的线程池: core = max, 都不可以回收
   *        - 实现控制线程的最大并发数
   *        - 超出的任务会在queue里等待
   *     2. Executors.newCachedThreadPool():
   *        - 创建一个可以缓存的线程池: core = 0, , 都可以回收
   *        - 如果线程池长度超过处理需要, 可以灵活的回收线程
   *        - 若无可回收则新建线程
   *     3. Executors.newScheduledThreadPool(10)
   *        - 创建一个定长的线程池: core = max, 都不可以回收
   *        - 支持定时和周期任务的执行
   *     4. Executors.newSingleThreadExecutor();
   *        - 创建一个单线程化的线程池: core = max = 1, 不可以回收
   *        - 只会使用唯一的线程来工作
   * </pre>
   */
  @Deprecated private static ExecutorService service = Executors.newScheduledThreadPool(10);

  private static ThreadPoolExecutor executor =
      initThreadPoolExecutor(
          5,
          200,
          10,
          TimeUnit.SECONDS,
          new LinkedBlockingDeque<>(10_0000),
          Executors.defaultThreadFactory(),
          new ThreadPoolExecutor.AbortPolicy());

  public static void main(String[] args) {
    log.info("main method start ...");
    Future<?> submit = service.submit(new RunnableCreate.CRunnable());
    log.info("main method end ...");

    log.info("main method start 2 ...");
    Future<?> submit1 = executor.submit(new RunnableCreate.CRunnable());
    log.info("main method end 2 ...");
  }

  /**
   * Init ThreadPoolExecutor with 7 parameters. <br>
   *
   * <pre>
   *    1. 线程池创建, 准备好 core 数量的核心线程, 准备接受任务
   *    2. 新的任务进来, 用 core 准备好的空闲线程执行
   *      - core 满了, 九江再进来的任务放入阻塞队列, 空闲的core就会自己去queue中回去任务并执行
   *      - queue 满了, 才会开新的线程执行, 直到达到线程的最大数量
   *      - 如果线程数量已是 max, 还有新的任务进来[且queue满了, 否则会放入 queue], 就会使用 handler 进行拒绝
   *      - 任务执行完了, max 个数的线程空闲下来, 则 max - core 个线程会在 keepAliveTime 之后被释放掉， 最终使得线程数量达到 core 个
   *    3. 所有的线程都是由指定的 factory 创建的
   *
   *    4. interview： 一个线程池 core: 7, max: 20, queue: 50, 此时 100 并发
   *      - 先有 7 个能被直接被执行
   *      - 50 个进入 queue
   *      - 之后开 13 个线程继续执行
   *      - 余下的 30 个使用 handler 进行拒绝
   *   </pre>
   *
   * @param corePoolSize: 一直存在[除非线程池销毁或者设置{@code allowCoreThreadTimeOut}], 线程池创建好之后就准备就绪的线程数量,
   *     等到接受异步任务去执行
   * @param maximumPoolSize: 最多线程数量, 控制资源
   * @param keepAliveTime: 当前线程数大于核心线程数后, 如果线程空闲大于 keepAliveTime 就会释放该线程, 释放的线程时 <code>
   *      maximumPoolSize - corePoolSize </code>
   * @param unit: keepAliveTime 的时间单位
   * @param blockingQueue: 如果任务很多, 则多出来的将任务放入queue里, 只要有线程空闲了就会从queue里取出任务执行, 容量默认是 Integer
   *     的最大值[一定要限制]
   * @param threadFactory: 线程创建工厂
   * @param handler: 如果队列满了, 就使用指定的策略拒绝向 queue 里放任务 - DiscardOldestPolicy: 丢弃最老的任务 -
   *     [默认]AbortPolicy: 直接丢弃新的任务, throw exception - CallerRunsPolicy: 转为同步调用 - DiscardPolicy:
   *     直接丢弃新的任务, 不 throw exception
   * @return ThreadPoolExecutor Instance
   */
  public static ThreadPoolExecutor initThreadPoolExecutor(
      int corePoolSize,
      int maximumPoolSize,
      long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> blockingQueue,
      ThreadFactory threadFactory,
      RejectedExecutionHandler handler) {

    return new ThreadPoolExecutor(
        corePoolSize, maximumPoolSize, keepAliveTime, unit, blockingQueue, threadFactory, handler);
  }
}
