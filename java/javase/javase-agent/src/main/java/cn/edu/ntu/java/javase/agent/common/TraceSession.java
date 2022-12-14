package cn.edu.ntu.java.javase.agent.common;

/**
 * @author zack <br>
 * @create 2020-09-20 19:00 <br>
 * @project javase <br>
 */
public class TraceSession {
    static ThreadLocal<TraceSession> session = new ThreadLocal<>();

    private String traceId;
    private String parentId;

    private int currentEventId;

    public TraceSession(String traceId) {
        this(traceId, "0");
    }

    public TraceSession(String traceId, String parentId) {
        this.traceId = traceId;
        this.parentId = parentId;
        session.set(this);
    }

    public static TraceSession getCurrentSession() {

        return session.get();
    }

    public static ThreadLocal<TraceSession> getSession() {
        return session;
    }

    public static void setSession(ThreadLocal<TraceSession> session) {
        TraceSession.session = session;
    }

    public int getNextCurrentEventId() {
        return ++currentEventId;
    }

    public void close() {
        session.remove();
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getCurrentEventId() {
        return currentEventId;
    }

    public void setCurrentEventId(int currentEventId) {
        this.currentEventId = currentEventId;
    }
}
