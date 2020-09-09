package cn.edu.ntu.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-09 19:21 <br>
 * @project json <br>
 */
public class JsonTokenTests {

    /**

     START_OBJECT       -> value:null

     FIELD_NAME         -> value:name
     VALUE_STRING       -> value:zack

     FIELD_NAME         -> value:age
     VALUE_NUMBER_INT   -> value:18

     FIELD_NAME         -> value:pickName
     VALUE_NULL         -> value:null

     END_OBJECT         -> value:null

     * @throws IOException
     */
  @Test
  public void testJson2BeanAboutJsonToken() throws IOException {
    String jsonStr = "{\"name\":\"zack\",\"age\":18, \"pickName\":null}";
    JsonFactory factory = new JsonFactory();
    try (JsonParser jsonParser = factory.createParser(jsonStr)) {

      while (true) {
        JsonToken token = jsonParser.nextToken();
        System.out.println(token + " -> value:" + jsonParser.getValueAsString());

        if (token == JsonToken.END_OBJECT) {
          break;
        }
      }
    }
  }
}
