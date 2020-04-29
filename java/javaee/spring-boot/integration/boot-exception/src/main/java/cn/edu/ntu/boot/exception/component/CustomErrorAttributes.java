package cn.edu.ntu.boot.exception.component;

import cn.edu.ntu.javaee.boot.common.constants.HttpConstants;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author zack
 * @create 2019-12-25 22:33
 * @function custom error message, put to response
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
    map.put("name", "zack");

    Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute(HttpConstants.EXT, 0);
    map.put(HttpConstants.EXT, ext);

    Integer status = (Integer) webRequest.getAttribute(HttpConstants.SERVER_CODE, 0);
    // http code
    webRequest.setAttribute(HttpConstants.JAVAX_SERVLET_ERROR_STATUS_CODE, status, 0);

    // response status
    map.put(HttpConstants.STATUS, status);
    return map;
  }
}
