package com.augmentum.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zack
 * @create 2019-07-27 23:50
 * @function
 */
public class LoggingInterceptor implements HandlerInterceptor {

    /**
     * 会话ID
     */
    private final static String SESSION_TOKEN_KEY = "sessionTokenId";

    private static final transient Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放SessionId
        String token = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        MDC. put(SESSION_TOKEN_KEY, token);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 其他逻辑代码

        // 最后执行MDC删除
        MDC. remove(SESSION_TOKEN_KEY);
    }
}