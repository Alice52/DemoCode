package cn.edu.ntu.common.api.redis.serializer;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2021-01-04 21:41 <br>
 * @project springboot <br>
 */
public class DateTimeJsonSerializer extends JsonSerializer<DateTime> {
    @Override
    public void serialize(
            DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
