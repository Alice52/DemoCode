package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.User;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-09 18:56 <br>
 * @project json <br>
 */
public class JsonParserTests {

    @Test
    public void testJson2Bean() throws IOException {
        String jsonStr = "{\"name\":\"zack\",\"age\":18}";
        User user = new User();

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {

            // 只要还没结束"}", 就一直读
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("name".equals(fieldName)) {
                    jsonParser.nextToken();
                    user.setName(jsonParser.getText());
                } else if ("age".equals(fieldName)) {
                    jsonParser.nextToken();
                    user.setAge(jsonParser.getIntValue());
                }
            }

            System.out.println(user);
        }
    }

    @Test
    public void testObjectCodec() throws IOException {
        String jsonStr = "{\"name\":\"zack\",\"age\":18}";

        JsonFactory factory = JsonFactory.builder().build();
        try (JsonParser parser = factory.createParser(jsonStr)) {
            parser.setCodec(new UserObjectCodec());
            User user = parser.readValueAs(User.class);
            System.out.println(user);
        }
    }
}
