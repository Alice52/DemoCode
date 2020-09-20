package cn.edu.ntu.javase.agent;

/**
 * @author zack <br>
 * @create 2020-09-19 22:27 <br>
 * @project javase <br>
 */
public class Server {

  public String sayHello(String str) {
    System.out.println("server 2.0");
    return "hello in server: " + str;
  }

  //  public String sayHello$agent1(String str) {
  //    long start = System.nanoTime();
  //    try {
  //      return sayHello(str);
  //    } finally {
  //      long end = System.nanoTime();
  //      System.out.println("time spend: " + (end - start));
  //    }
  //  }
}
