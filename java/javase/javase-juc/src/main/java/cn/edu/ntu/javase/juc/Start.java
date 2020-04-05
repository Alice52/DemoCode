package cn.edu.ntu.javase.juc;

/**
 * @author zack
 * @create 2019-12-13 23:12
 * @function
 */
public class Start {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> System.out.println("Thread executed"), "Thread01");

    thread.start();
    // thread.start(); // Exception in thread "main" java.lang.IllegalThreadStateException
  }
}
