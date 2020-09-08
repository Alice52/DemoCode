package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.User;
import cn.edu.ntu.json.model.UserTreeNode;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-08 22:08 <br>
 * @project json <br>
 */
public class JsonGeneratorPojoTests {

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
