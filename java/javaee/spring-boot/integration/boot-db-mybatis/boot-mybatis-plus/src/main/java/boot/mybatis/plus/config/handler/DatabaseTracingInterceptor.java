package boot.mybatis.plus.config.handler;

import brave.Span;
import brave.Tracer;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author zack <br>
 * @create 2021-04-20 17:00 <br>
 * @project boot-mybatis-common <br>
 */
@Slf4j
@Intercepts({
    @Signature(
            type = StatementHandler.class,
            method = "prepare",
            args = {Connection.class, Integer.class})
})
public class DatabaseTracingInterceptor implements Interceptor {
    private static final String SPAN_NAME = "database";

    private static final String TAG_MAPPER = "mapper";
    private static final String TAG_STATEMENT = "db.statement";
    private static final String TAG_INSTANCE = "db.instance";

    @Autowired Tracer tracer;

    @Value("${spring.application.name}")
    String serviceName;

    @Override
    @SneakyThrows
    public Object intercept(Invocation invocation) {
        Span span = tracer.nextSpan().name(SPAN_NAME);
        span.tag(TAG_INSTANCE, serviceName);
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(span.start())) {
            StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());
            MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
            MappedStatement mappedStatement =
                    (MappedStatement) metaObject.getValue("delegate.mappedStatement");
            span.tag(TAG_MAPPER, mappedStatement.getId());

            BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
            span.tag(TAG_STATEMENT, boundSql.getSql());

            return invocation.proceed();
        } finally {
            span.finish();
        }
    }

    /**
     * 生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * mybatis配置的属性
     *
     * @param properties mybatis配置的属性
     */
    @Override
    public void setProperties(Properties properties) {}
}
