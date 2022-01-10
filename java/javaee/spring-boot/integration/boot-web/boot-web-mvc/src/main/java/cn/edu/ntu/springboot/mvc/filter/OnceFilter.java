package cn.edu.ntu.springboot.mvc.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zack <br>
 * @create 2021-05-13<br>
 * @project integration <br>
 */
@Component
public class OnceFilter extends OncePerRequestFilter {

    /**
     * 注入 IOC:
     *
     * <pre>
     *    FilterRegistrationBean.setFilter(new OnceFilter());
     *    filterRegistrationBean.addUrlPatterns("/*");
     * </pre>
     *
     * <pre>
     *     @WebFilter(filterName = " myFilter ", urlPatterns = "/*")
     * </pre>
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("MyFilter...");
        filterChain.doFilter(request, response);
    }
}
