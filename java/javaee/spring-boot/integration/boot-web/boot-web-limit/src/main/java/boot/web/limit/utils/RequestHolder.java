package boot.web.limit.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zack <br>
 * @create 2021-04-12 17:55 <br>
 * @project integration <br>
 */
public final class RequestHolder {
  private static final String BEARER_ = "Bearer ";

  public static HttpServletRequest getCurrentRequest() {
    // 获得request对象
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    return sra.getRequest();
  }

  public static String getCurrentToken() {
    HttpServletRequest request = getCurrentRequest();

    String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (header == null || !header.startsWith(BEARER_)) {
      throw new RuntimeException("请求头中Authorization信息为空");
    }

    return header.replace(BEARER_, "");
  }
}
