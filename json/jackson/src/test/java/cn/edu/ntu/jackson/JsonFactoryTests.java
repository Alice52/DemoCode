package cn.edu.ntu.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.util.ServiceLoader;

import static com.fasterxml.jackson.core.JsonFactory.Feature.INTERN_FIELD_NAMES;
import static com.fasterxml.jackson.core.StreamWriteFeature.AUTO_CLOSE_CONTENT;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_SINGLE_QUOTES;

/**
 * @author zack <br>
 * @create 2020-09-14 20:08 <br>
 * @project json <br>
 */
public class JsonFactoryTests {

  @Test
  public void testCreateGenerator() throws IOException {
    String jsonStr = "{\"age\":18, \"age\": 28 }";
    JsonFactory factory =
        JsonFactory.builder()
            // factory
            .enable(INTERN_FIELD_NAMES)
            // parser
            .enable(ALLOW_SINGLE_QUOTES, ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
            // generator
            .enable(AUTO_CLOSE_CONTENT)
            .build();
    // if un-comment will throw JsonParseException
    // factory.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);

    try (JsonParser jsonParser = factory.createParser(jsonStr)) {
      while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
        String fieldName = jsonParser.getCurrentName();
        if ("age".equals(fieldName)) {
          jsonParser.nextToken();
          System.out.println(jsonParser.getIntValue());
        }
      }
    }
  }

  @Test
  public void testSpiCreate() {
    ServiceLoader<JsonFactory> jsonFactories = ServiceLoader.load(JsonFactory.class);
    System.out.println(jsonFactories.iterator().next());
  }
}
