package cn.edu.ntu.javase.agent;

import cn.edu.ntu.javase.agent.common.TraceSession;
import cn.edu.ntu.javase.agent.common.WildcardMatcher;
import javassist.*;
import javassist.bytecode.AccessFlag;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-09-20 13:02 <br>
 * @project javase <br>
 */
public class ServerAgent {

    public static void premain(String arg, Instrumentation instrumentation) {

        System.out.println("ServerAgent premain");

        WildcardMatcher matcher = new WildcardMatcher(arg);

        instrumentation.addTransformer(
                (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
                    if (className == null || loader == null) {
                        return null;
                    }

                    className = className.replace("/", ".");
                    if (!matcher.matches(className)) {
                        return null;
                    }

                    try {
                        return buildMonitorClass(loader, className);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return null;
                },
                true);
    }

    private static byte[] buildMonitorClass(ClassLoader loader, String className)
            throws NotFoundException, CannotCompileException, IOException {

        ClassPool pool = new ClassPool();
        pool.insertClassPath(new LoaderClassPath(loader));

        CtClass ctClass = pool.get(className);

        for (CtMethod method : ctClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (!AccessFlag.isPublic(modifiers)) {
                continue;
            }

            if ((modifiers & AccessFlag.ABSTRACT) != 0) {
                continue;
            }

            if ((modifiers & AccessFlag.STATIC) != 0) {
                continue;
            }

            if ((modifiers & AccessFlag.NATIVE) != 0) {
                continue;
            }

            CtMethod copyMethod = CtNewMethod.copy(method, ctClass, new ClassMap());
            method.setName(method.getName() + "$agent");

            String returnClassName = copyMethod.getReturnType().getName();
            if ("void".equals(returnClassName)) {
                copyMethod.setBody(
                        "{\n"
                                + "\n"
                                + "            Object trace = cn.edu.ntu.javase.agent.ServerAgent.begin($args);\n"
                                + "            try{\n"
                                + copyMethod.getName()
                                + "$agent($$);\n"
                                + "            } finally{\n"
                                + "                cn.edu.ntu.javase.agent.ServerAgent.end(trace);\n"
                                + "            }\n"
                                + "          }");
            } else {
                copyMethod.setBody(
                        "{\n"
                                + "\n"
                                + "            Object trace = cn.edu.ntu.javase.agent.ServerAgent.begin($args);\n"
                                + "            try{\n"
                                + "               return "
                                + copyMethod.getName()
                                + "$agent($$);\n"
                                + "            } finally{\n"
                                + "                cn.edu.ntu.javase.agent.ServerAgent.end(trace);\n"
                                + "            }\n"
                                + "          }");
            }

            ctClass.addMethod(copyMethod);
        }

        return ctClass.toBytecode();
    }

    public static TraceInfo begin(Object[] args) {
        TraceInfo traceInfo = new TraceInfo(System.nanoTime(), args);
        TraceSession session = TraceSession.getCurrentSession();

        if (null != session) {
            traceInfo.setTraceId(session.getTraceId());
            traceInfo.setEventId(session.getParentId() + "." + session.getNextCurrentEventId());
        }

        return traceInfo;
    }

    public static void end(Object param) {
        TraceInfo traceInfo = TraceInfo.class.cast(param);
        System.out.println(traceInfo);
    }

    public static class TraceInfo {

        private String traceId;
        private String EventId;
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

        @Override
        public String toString() {
            return "TraceInfo{"
                    + "traceId='"
                    + traceId
                    + '\''
                    + ", EventId='"
                    + EventId
                    + '\''
                    + ", begin="
                    + begin
                    + ", args="
                    + Arrays.toString(args)
                    + '}';
        }
    }
}
