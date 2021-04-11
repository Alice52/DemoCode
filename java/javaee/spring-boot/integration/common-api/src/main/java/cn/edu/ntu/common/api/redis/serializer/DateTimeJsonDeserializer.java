package cn.edu.ntu.common.api.redis.serializer;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * @author zack <br>
 * @create 2021-01-04 21:39 <br>
 * @project springboot <br>
 */
public class DateTimeJsonDeserializer extends JsonDeserializer<DateTime> {

  @Override
  public DateTime deserialize(
      com.fasterxml.jackson.core.JsonParser jsonParser, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    String dateString = jsonParser.readValueAs(String.class);
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    return DateUtil.parse(dateString, timeFormatter);
  }
}
