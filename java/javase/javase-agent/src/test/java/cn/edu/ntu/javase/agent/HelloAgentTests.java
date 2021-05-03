package cn.edu.ntu.javase.agent;

/**
 * @author zack <br>
 * @create 2020-09-19 22:05 <br>
 * @project javase <br>
 */
public class HelloAgentTests {

    // -javaagent:F:\repository\tutorials-sample\java\javase\javase-agent\target\javase-agent-1.0-SNAPSHOT.jar
    public static void main(String[] args) {

        System.out.println("hello java agent test: " + args);

        new Server().sayHello("zack");
    }
}
