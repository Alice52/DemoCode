package cn.edu.ntu.common.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2021-01-04 22:16 <br>
 * @project springboot <br>
 */
public final class JacksonUtils {

  private static final ObjectMapper mapper = new ObjectMapper();

  public static String toJsonString(Object obj) throws JsonProcessingException {
    return mapper.writeValueAsString(obj);
  }
}
