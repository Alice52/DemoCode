package com.augmentum.springboot.integration.component;

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

    Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
    map.put("ext", ext);
    return map;
  }
}
