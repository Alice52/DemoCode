package cn.edu.ntu.java.javase.agent;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author zack <br>
 * @create 2020-09-20 19:17 <br>
 * @project javase <br>
 */
public class IntegrationTests {

    // -javaagent:F:\repository\tutorials-sample\java\javase\javase-agent\target\javase-agent-1.0-SNAPSHOT.jar=cn.edu.ntu.javase.agent.*Server
    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new Server(8008);
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase(WebAgentTests.class.getResource("/webapp/").getPath());
        context.setDescriptor(WebAgentTests.class.getResource("/webapp/WEB-INF/web.xml").getPath());

        server.setHandler(context);
        server.start();
        System.out.println("jetty is startup");
        server.join();
    }
}
