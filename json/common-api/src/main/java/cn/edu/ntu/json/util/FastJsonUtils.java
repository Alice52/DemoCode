package cn.edu.ntu.json.util;

import com.alibaba.fastjson.JSON;

/**
 * @author zack <br>
 * @create 2020-09-07 21:12 <br>
 * @project json <br>
 */
public class FastJsonUtils {
  public static String bean2Json(Object obj) {
    return JSON.toJSONString(obj);
  }

  public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
    return JSON.parseObject(jsonStr, objClass);
  }
}
