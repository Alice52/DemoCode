package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.User;
import cn.edu.ntu.json.model.UserTreeNode;
import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.junit.Test;

import java.io.IOException;

/**
 * 1. 只负责JSON的生成, 至于把生成好的JSON写到哪里去它并不关心
 *
 * <p>
 *
 * @author zack <br>
 * @create 2020-09-07 22:04 <br>
 * @project json <br>
 */
public class JsonGeneratorTests {

    /**
     * {"name":"zack","age":18}
     *
     * @throws IOException
     */
    @Test
    public void testHello() throws IOException {
        JsonFactory factory = new JsonFactory();

        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            // {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "zack");
            jsonGenerator.writeNumberField("age", 18);

            // }
            jsonGenerator.writeEndObject();
        }
    }

    /**
     * {"-3796559236860403187":"zack","name":"a","full-name":"zhang","person":{"name":"zack","age":18},"objects":["zack",{"name":"zack"},18],"values":[3,4,5],"boolean":true,"null":null}
     *
     * @throws IOException
     */
    @Test
    public void testJsonApi() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldId(RandomUtil.randomLong());
            jsonGenerator.writeString("zack");

            jsonGenerator.writeFieldName("name");
            jsonGenerator.writeString("zack".toCharArray(), 1, 1);

            jsonGenerator.writeFieldName(new SerializedString("full-name"));
            jsonGenerator.writeString(new SerializedString("zhang"));

            jsonGenerator.writeFieldName("person");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("name");
            // string
            jsonGenerator.writeString("zack");
            jsonGenerator.writeFieldName("age");
            // number
            jsonGenerator.writeNumber(18);
            jsonGenerator.writeEndObject();

            // objects
            jsonGenerator.writeFieldName("objects");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeString("zack");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "zack");
            jsonGenerator.writeEndObject();
            jsonGenerator.writeNumber(18);
            jsonGenerator.writeEndArray();

            // arrays
            jsonGenerator.writeFieldName("values");
            jsonGenerator.writeArray(new int[] {1, 2, 3, 4, 5, 6}, 2, 3);

            // boolean
            jsonGenerator.writeFieldName("boolean");
            jsonGenerator.writeBoolean(true);

            // null
            jsonGenerator.writeFieldName("null");
            jsonGenerator.writeNull();

            jsonGenerator.writeEndObject();
        }
    }

    /**
     * {"name":"zack","success":true,"dead":null,"array":[],"objects":{"dead":null}}
     *
     * @throws IOException
     */
    @Test
    public void testJsonKeyValueApi() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeStringField("name", "zack");
            jsonGenerator.writeBooleanField("success", true);
            jsonGenerator.writeNullField("dead");
            jsonGenerator.writeArrayFieldStart("array");
            jsonGenerator.writeEndArray();

            jsonGenerator.writeObjectFieldStart("objects");
            jsonGenerator.writeNullField("dead");
            jsonGenerator.writeEndObject();
        }
    }

    /** @throws IOException */
    @Test
    public void testOtherApi() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {

            // {'name':'zack'}
            jsonGenerator.writeRaw("{'name':'zack'}");

            // "{'name':'zack'}"
            jsonGenerator.writeString("{'name':'zack'}");
        }
    }

    /**
     * {"name":"zack","age":10}
     *
     * @throws IOException
     */
    @Test
    public void testWriteObject() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
            jsonGenerator.setCodec(new UserObjectCodec());

            jsonGenerator.writeObject(new User("zack", 10));
        }
    }

    /**
     * {"name":"zack","age":10}
     *
     * @throws IOException
     */
    @Test
    public void testTreeNode() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
            jsonGenerator.setCodec(new UserObjectCodec());
            jsonGenerator.writeObject(new UserTreeNode(new User("zack", 10)));
        }
    }
}
