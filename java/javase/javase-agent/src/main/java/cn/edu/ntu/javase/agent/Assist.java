package cn.edu.ntu.javase.agent;

import javassist.*;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-09-19 23:37 <br>
 * @project javase <br>
 */
public class Assist {

  /**
   * add one statement by redefineClasses, but insertBefore code is dynamic block
   *
   * @param args
   * @param instrumentation
   * @throws Exception
   */
  public static void premain1(String args, Instrumentation instrumentation) throws Exception {

    byte[] bytes = null;
    ClassPool pool = new ClassPool();
    pool.appendSystemPath();
    CtClass ctClass = pool.get(Server.class.getName());
    CtMethod sayHello = ctClass.getDeclaredMethod("sayHello");
    sayHello.insertBefore("System.out.println(System.currentTimeMillis());");
    bytes = ctClass.toBytecode();
    instrumentation.redefineClasses(new ClassDefinition(Server.class, bytes));
  }

  public static void premain(String args, Instrumentation instrumentation) throws Exception {

    instrumentation.addTransformer(
        (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
          if (!className.equals("cn/edu/ntu/javase/agent/Server")) {
            return null;
          }
          try {
            return buildMonitorClass();
          } catch (Exception e) {
            e.printStackTrace();
          }
          return null;
        },
        true);
  }

  private static byte[] buildMonitorClass() throws Exception {
    ClassPool pool = new ClassPool();
    pool.appendSystemPath();
    CtClass ctClass = pool.get("cn.edu.ntu.javase.agent.Server");
    CtMethod sayHello = ctClass.getDeclaredMethod("sayHello");

    CtMethod sayHelloCopy = CtNewMethod.copy(sayHello, ctClass, new ClassMap());
    sayHello.setName("sayHello$agent");
    sayHelloCopy.setBody(
        "{\n"
            + "    long start = System.nanoTime();\n"
            + "    try {\n"
            + "      return sayHello$agent($$);\n"
            + "    } finally {\n"
            + "      long end = System.nanoTime();\n"
            + "      System.out.println(\"time spend: \" + (end - start));\n"
            + "    }\n"
            + "  }");

    ctClass.addMethod(sayHelloCopy);

    return ctClass.toBytecode();
  }

  public static TraceInfo begin(Object[] args) {
    return new TraceInfo(System.nanoTime(), args);
  }

  public static void end(Object param) {
    TraceInfo traceInfo = TraceInfo.class.cast(param);

    System.out.println("execute spend: " + (System.nanoTime() - traceInfo.getBegin()));
    System.out.println("execute args: " + Arrays.toString(traceInfo.getArgs()));
  }

  public static class TraceInfo {

    private long begin;
    private Object[] args;

    public TraceInfo() {}

    public TraceInfo(long begin, Object[] args) {
      this.begin = begin;
      this.args = args;
    }

    public long getBegin() {
      return begin;
    }

    public void setBegin(long begin) {
      this.begin = begin;
    }

    public Object[] getArgs() {
      return args;
    }

    public void setArgs(Object[] args) {
      this.args = args;
    }
  }
}
