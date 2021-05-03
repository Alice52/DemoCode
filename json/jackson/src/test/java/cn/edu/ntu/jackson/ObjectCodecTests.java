package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.User;
import com.fasterxml.jackson.core.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-14 21:43 <br>
 * @project json <br>
 */
public class ObjectCodecTests {

    private JsonFactory factory = new JsonFactoryBuilder().build();

    @Test
    public void testRead() throws IOException {
        String json = "{\"name\": \"zack\", \"age\": 18 }";
        try (JsonParser parser = factory.createParser(json); ) {
            parser.setCodec(new UserObjectCodec());
            User user = parser.readValueAs(User.class);

            System.out.println(user);
        }
    }

    @Test
    public void testWrite() throws IOException {

        try (JsonGenerator jsonGenerator =
                factory.createGenerator(System.err, JsonEncoding.UTF8); ) {
            jsonGenerator.setCodec(new UserObjectCodec());
            jsonGenerator.writeObject(new User("zack", 18));
        }
    }
}
