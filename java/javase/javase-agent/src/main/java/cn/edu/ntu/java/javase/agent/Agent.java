package cn.edu.ntu.java.javase.agent;

import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author zack <br>
 * @create 2020-09-19 22:03 <br>
 * @project javase <br>
 */
public class Agent {

    public static void premain(String arg, Instrumentation instrumentation) {
        System.out.println("hello java agent: " + arg);
        // this will lead to addTransformer invalid due to it just work for first load
        Server server = new Server();
        // server 2.0
        server.sayHello("aa");

        InputStream inputStream = Agent.class.getResourceAsStream("/Server.class");
        /** Each class loaded to jvm will pass through this method. */

        // re-load-class: 01 addTransformer
        //    instrumentation.addTransformer(
        //        (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
        //          if (!className.equals("cn/edu/ntu/javase/agent/Server")) {
        //            return null;
        //          }
        //
        //          try {
        //            return IOUtils.readFully(inputStream, -1, false);
        //          } catch (IOException e) {
        //            e.printStackTrace();
        //          }
        //          return null;
        //        });

        // re-load-class: 02 retransformClasses: can add method
        instrumentation.addTransformer(
                (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
                    if (!className.equals("cn/edu/ntu/javase/agent/Server")) {
                        return null;
                    }
                    try {
                        return IOUtils.readFully(inputStream, -1, false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                },
                true);
        try {
            instrumentation.retransformClasses(Server.class);
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        }

        // re-load-class: 03 redefineClasses: cannot add method
        //    try {
        //      byte[] bytes = IOUtils.readFully(inputStream, -1, false);
        //      instrumentation.redefineClasses(new ClassDefinition(Server.class, bytes));
        //      // server 1.0
        //      server.sayHello("aa");
        //
        //    } catch (IOException e) {
        //      e.printStackTrace();
        //    } catch (ClassNotFoundException e) {
        //      e.printStackTrace();
        //    } catch (UnmodifiableClassException e) {
        //      e.printStackTrace();
        //    }

    }
}
