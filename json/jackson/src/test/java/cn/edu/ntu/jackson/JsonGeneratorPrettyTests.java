package cn.edu.ntu.jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-08 22:03 <br>
 * @project json <br>
 */
public class JsonGeneratorPrettyTests {

    /**
     * { "name" : "zack", "20200908" : 18 }
     *
     * @throws IOException
     */
    @Test
    public void testPretty() throws IOException {

        JsonFactory factory = JsonFactory.builder().build();

        try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
            jg.useDefaultPrettyPrinter(); // jg.setPrettyPrinter(new DefaultPrettyPrinter());
            jg.writeStartObject();

            jg.writeStringField("name", "zack");
            jg.writeFieldId(20200908);
            jg.writeNumber(18);
            jg.writeEndObject();
        }
    }
}
