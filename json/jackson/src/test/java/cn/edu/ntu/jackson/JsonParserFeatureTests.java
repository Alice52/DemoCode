package cn.edu.ntu.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-09 19:44 <br>
 * @project json <br>
 */
public class JsonParserFeatureTests {

    @Test
    public void testAllowComments() throws IOException {
        String jsonStr = "{\n" + "\t\"name\" : \"zack\", // 名字\n" + "\t\"age\" : 18 // 年龄\n" + "}";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // comment this statement, will throw JsonParseException
            jsonParser.enable(JsonParser.Feature.ALLOW_COMMENTS);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("name".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText());
                } else if ("age".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getIntValue());
                }
            }
        }
    }

    @Test
    public void testAllowBackslashEscapingAnyCharacter() throws IOException {
        String jsonStr = "{\"name\" : \"YourB\\'atman\" }";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // comment this statement, will throw JsonParseException
            jsonParser.enable(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("name".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText());
                }
            }
        }
    }

    /**
     * 18
     *
     * @throws IOException
     */
    @Test
    public void testAllowNumericLeadingZeros() throws IOException {
        String jsonStr = "{\"age\" : 00018 }";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // comment this statement, will throw JsonParseException
            jsonParser.enable(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("age".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getIntValue());
                }
            }
        }
    }

    /**
     * NaN
     *
     * @throws IOException
     */
    @Test
    public void testAllowNonNumericNumbers() throws IOException {
        String jsonStr = "{\"percent\" : NaN }";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // comment this statement, will throw JsonParseException
            jsonParser.enable(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("percent".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getFloatValue());
                }
            }
        }
    }

    @Test
    public void testAllowMissingValues() throws IOException {
        String jsonStr = "{\"names\" : [\"zack\",,\"timothy\",,] }";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // comment this statement, will throw JsonParseException
            jsonParser.enable(JsonParser.Feature.ALLOW_MISSING_VALUES);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("names".equals(fieldName)) {
                    jsonParser.nextToken();

                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println(jsonParser.getText());
                    }
                }
            }
        }
    }

    /**
     * ALLOW_TRAILING_COMMA: higher priority
     *
     * @throws IOException
     */
    @Test
    public void testAllowTrailingComma() throws IOException {
        String jsonStr = "{\"results\" : [true,true,,] }";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            jsonParser.enable(JsonParser.Feature.ALLOW_MISSING_VALUES);
            jsonParser.enable(JsonParser.Feature.ALLOW_TRAILING_COMMA);

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("results".equals(fieldName)) {
                    jsonParser.nextToken();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println(jsonParser.getText());
                    }
                }
            }
        }
    }

    @Test
    public void testStrictDuplicateDetection() throws IOException {
        String jsonStr = "{\"age\":18, \"age\": 28 }";

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {
            // jsonParser.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION); //
            // JsonParseException
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("age".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getIntValue());
                }
            }
        }
    }
}
