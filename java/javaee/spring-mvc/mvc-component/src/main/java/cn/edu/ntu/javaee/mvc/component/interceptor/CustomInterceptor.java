package cn.edu.ntu.javaee.mvc.component.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Execute sequence according to config sequence, same as Filter. <br>
 * And need register in mvc.xml
 *
 * @author zack
 * @date
 */
@Component
public class CustomInterceptor implements HandlerInterceptor {

    /** from first to last */
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    /** from last to first */
    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {}

    /** from last to first */
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}
}
