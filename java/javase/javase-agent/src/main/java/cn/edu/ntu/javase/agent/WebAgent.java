package cn.edu.ntu.javase.agent;

import cn.edu.ntu.javase.agent.common.TraceSession;
import javassist.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * @author zack <br>
 * @create 2020-09-20 16:47 <br>
 * @project javase <br>
 */
public class WebAgent {

    public static void premain(String arg, Instrumentation instrumentation) {

        System.out.println("WebAgent premain");

        // target is to intercept `protected void service(HttpServletRequest req,
        // HttpServletResponse
        // resp) throws ServletException, IOException {`
        instrumentation.addTransformer(
                (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
                    if (className == null
                            || loader == null
                            || !"javax/servlet/http/HttpServlet".equals(className)) {
                        return null;
                    }

                    byte[] bytes = null;
                    try {
                        bytes = build(loader, className.replaceAll("/", "."));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return bytes;
                });
    }

    public static byte[] build(ClassLoader loader, String className)
            throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = new ClassPool();
        pool.insertClassPath(new LoaderClassPath(loader));
        CtClass ctClass = pool.get(className);

        CtMethod method =
                ctClass.getDeclaredMethod(
                        "service",
                        pool.get(
                                new String[] {
                                    "javax.servlet.http.HttpServletRequest",
                                    "javax.servlet.http.HttpServletResponse"
                                }));

        CtMethod copyMethod = CtNewMethod.copy(method, ctClass, new ClassMap());
        method.setName(method.getName() + "$agent");
        copyMethod.setBody(
                "{\n"
                        + "\n"
                        + "            Object trace = cn.edu.ntu.javase.agent.WebAgent.begin($args);\n"
                        + "            try{\n"
                        + copyMethod.getName()
                        + "$agent($$);\n"
                        + "            } finally{\n"
                        + "                cn.edu.ntu.javase.agent.WebAgent.end(trace);\n"
                        + "            }\n"
                        + "          }");

        ctClass.addMethod(copyMethod);

        return ctClass.toBytecode();
    }

    /**
     * insert code in first line of HttpServlet#service
     *
     * @param args
     * @return
     */
    public static WebTraceInfo begin(Object[] args) {

        HttpServletRequest request = HttpServletRequest.class.cast(args[0]);
        HttpServletResponse response = HttpServletResponse.class.cast(args[1]);
        WebTraceInfo traceInfo = new WebTraceInfo();
        traceInfo.setUrl(request.getRequestURI());
        // args[0].getClass().getMethod("getParameterMap").invoke(args[0].getClass());
        traceInfo.setParameters(request.getParameterMap());
        traceInfo.setCookie(request.getCookies());
        traceInfo.setBegin(System.nanoTime());
        String traceId = UUID.randomUUID().toString();
        TraceSession session = new TraceSession(traceId);
        traceInfo.setTraceId(traceId);
        traceInfo.setEventId(session.getParentId() + "." + session.getNextCurrentEventId());

        return traceInfo;
    }

    /**
     * insert code in last line of HttpServlet#service
     *
     * @param param
     */
    public static void end(Object param) {
        WebTraceInfo webTraceInfo = WebTraceInfo.class.cast(param);
        webTraceInfo.setUserTime(System.nanoTime() - webTraceInfo.getBegin());
        System.out.println(webTraceInfo);

        TraceSession.getCurrentSession().close();
    }

    private static class WebTraceInfo {
        private String traceId;
        private String EventId;
        private long begin;
        private String url;
        private Map<String, String[]> parameters;
        private Cookie[] cookie;
        private String header;
        private long userTime;

        public WebTraceInfo() {}

        public WebTraceInfo(
                long begin,
                String url,
                Map<String, String[]> parameters,
                Cookie[] cookie,
                String header,
                long userTime) {
            this.begin = begin;
            this.url = url;
            this.parameters = parameters;
            this.cookie = cookie;
            this.header = header;
            this.userTime = userTime;
        }

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }

        public String getEventId() {
            return EventId;
        }

        public void setEventId(String eventId) {
            EventId = eventId;
        }

        public long getBegin() {
            return begin;
        }

        public void setBegin(long begin) {
            this.begin = begin;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Map<String, String[]> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String[]> parameters) {
            this.parameters = parameters;
        }

        public Cookie[] getCookie() {
            return cookie;
        }

        public void setCookie(Cookie[] cookie) {
            this.cookie = cookie;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public long getUserTime() {
            return userTime;
        }

        public void setUserTime(long userTime) {
            this.userTime = userTime;
        }

        @Override
        public String toString() {
            return "WebTraceInfo{"
                    + "traceId='"
                    + traceId
                    + '\''
                    + ", EventId='"
                    + EventId
                    + '\''
                    + ", begin="
                    + begin
                    + ", url='"
                    + url
                    + '\''
                    + ", parameters="
                    + parameters
                    + ", cookie="
                    + Arrays.toString(cookie)
                    + ", header='"
                    + header
                    + '\''
                    + ", userTime="
                    + userTime
                    + '}';
        }
    }
}
