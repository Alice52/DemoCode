package cn.edu.ntu.javase.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author zack <br>
 * @create 2020-09-20 19:16 <br>
 * @project javase <br>
 */
public class IntegrationAgent {
  public static void premain(String arg, Instrumentation instrumentation) {
    WebAgent.premain(arg, instrumentation);
    ServerAgent.premain(arg, instrumentation);
  }
}
