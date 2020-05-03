package cn.edu.ntu.javaee.springmvc.servlet.async;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.web.context.request.async.DeferredResult;

/** @author zack */
public class DeferredResultQueue {

  private static Queue<DeferredResult<Object>> queue =
      new ConcurrentLinkedQueue<DeferredResult<Object>>();

  public static void save(DeferredResult<Object> deferredResult) {
    queue.add(deferredResult);
  }

  public static DeferredResult<Object> get() {
    return queue.poll();
  }
}
