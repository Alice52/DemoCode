package cn.edu.ntu.java.javase.agent;

/**
 * @author zack <br>
 * @create 2020-09-20 13:40 <br>
 * @project javase <br>
 */
public class ServerAgentTests {
    // -javaagent:F:\repository\tutorials-sample\java\javase\javase-agent\target\javase-agent-1.0-SNAPSHOT.jar=cn.edu.ntu.javase.agent.*Server
    public static void main(String[] args) {

        System.out.println("ServerAgentTests: " + args);
        new Server().sayHello("zack11");
    }
}
