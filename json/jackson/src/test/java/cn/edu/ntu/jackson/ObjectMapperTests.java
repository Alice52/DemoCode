package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.FullName;
import cn.edu.ntu.json.model.Person;
import cn.edu.ntu.json.model.User;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author zack <br>
 * @create 2020-09-14 21:05 <br>
 * @project json <br>
 */
public class ObjectMapperTests {

  @Test
  public void testBind() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    // 绑定简单类型 和 Map类型
    Integer age = objectMapper.readValue("1", int.class);
    System.out.println(age);
    Map map = objectMapper.readValue("{\"name\":  \"zack\"}", Map.class);
    System.out.println(map);
  }

  @Test
  public void testBindPojo() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    User user = objectMapper.readValue("{\"name\":  \"zack\", \"age\": 18}", User.class);
    System.out.println(user);
  }

  @Test
  public void testWrite() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    System.out.println("----------canonical type----------");
    System.out.println(objectMapper.writeValueAsString(18));
    System.out.println(objectMapper.writeValueAsString("zack"));

    System.out.println("----------collection----------");
    System.out.println(objectMapper.writeValueAsString(Arrays.asList(1, 2, 3)));
    System.out.println(
        objectMapper.writeValueAsString(
            new HashMap<String, String>() {
              {
                put("zhName", "zack");
                put("enName", "zhang");
              }
            }));

    System.out.println("----------POJO----------");
    System.out.println(objectMapper.writeValueAsString(new User("zack", 18)));
  }

  @Test
  public void testRead() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    System.out.println("----------canonical type----------");
    System.out.println(objectMapper.readValue("18", Integer.class));
    // 抛错：JsonParseException  单独的一个串, 解析会抛错
    // System.out.println(objectMapper.readValue("zack", String.class));

    System.out.println("----------collection----------");
    System.out.println(objectMapper.readValue("[1,2,3]", List.class));
    System.out.println(
        objectMapper.readValue("{\"zhName\":\"zhang\",\"enName\":\"zack\"}", Map.class));

    System.out.println("----------POJO----------");
    System.out.println(objectMapper.readValue("{\"name\":\"zack\",\"age\":18}", User.class));
  }

  @Test
  public void testReadGeneric() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    System.out.println("----------collection----------");
    List<Long> list = objectMapper.readValue("[1,2,3]", List.class);
    // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
    // System.out.println(list.get(0));

    System.out.println("----------collection2----------");
    Data data = objectMapper.readValue("{\"ids\" : [1,2,3]}", Data.class);
    System.out.println(data.getIds().get(0));

    System.out.println("----------collection3----------");
    List<Long> ids = objectMapper.readValue("[1,2,3]", new TypeReference<List<Long>>() {});
    System.out.println(ids.get(0));
  }

  @Test
  public void testCreateJsonMapper() throws JsonProcessingException {
    JsonMapper jsonMapper =
        JsonMapper.builder().configure(JsonReadFeature.ALLOW_SINGLE_QUOTES, true).build();

    User user = jsonMapper.readValue("{'name':  'zack', 'age': 18}", User.class);
    System.out.println(user);
  }

  @lombok.Data
  private static class Data {
    private List<Long> ids;
  }

  @Test
  public void testTreeNode() {
    ObjectMapper mapper = new ObjectMapper();

    Person person = new Person();
    person.setAge(18);
    person.setName("zack");
    person.setFullName(new FullName("zhang", "zhuang", "zhuang"));

    JsonNode node = mapper.valueToTree(person);
    System.out.println(person);

    Iterator<JsonNode> it = node.iterator();
    while (it.hasNext()) {
      JsonNode nextNode = it.next();
      if (nextNode.isContainerNode()) {
        if (nextNode.isObject()) {
          System.out.println(nextNode.get("firstName"));
          System.out.println(nextNode.get("middleName"));
          System.out.println(nextNode.get("lastName"));
        }
      } else {
        System.out.println(nextNode.asText());
      }
    }

    System.out.println("--------------get directly-------------------------");
    System.out.println(node.get("fullName").get("firstName"));
    System.out.println(node.get("fullName").get("lastName"));
  }

  @Test
  public void testTreeNodeWriteTree() throws IOException {
    ObjectMapper mapper = new ObjectMapper();

    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jsonGenerator = factory.createGenerator(System.err, JsonEncoding.UTF8)) {

      Person person = new Person();
      person.setName("zack");
      person.setAge(18);
      JsonNode jsonNode = mapper.valueToTree(person);

      mapper.writeTree(jsonGenerator, jsonNode);
    }
  }

  @Test
  public void testTreeNodeReadTree() throws IOException {
    ObjectMapper mapper = new ObjectMapper();

    String jsonStr = "{\"name\":\"zack\",\"age\":18,\"fullName\":null}";
    JsonNode node = mapper.readTree(jsonStr);
    System.out.println(node.get("name"));
  }

  /**
   * Just get one property.
   *
   * @throws IOException
   */
  @Test
  public void testReadOneProperty() throws IOException {
    ObjectMapper mapper = new ObjectMapper();

    String jsonStr =
        "{\"name\":\"YourBatman\",\"age\":18,\"dog\":{\"name\":\"旺财\",\"color\":\"WHITE\"},\"hobbies\":[\"篮球\",\"football\"]}";
    JsonNode node = mapper.readTree(jsonStr);

    // if dog node is not exist, this will throw NPException.
    System.out.println(node.get("dog").get("color").asText());
  }

  /**
   * {"name":"zack","age":18,"myDiy":{"country":"China"}}
   *
   * @throws JsonProcessingException
   */
  @Test
  public void test5() throws JsonProcessingException {
    String jsonStr = "{\"name\":\"zack\",\"age\":18}";
    JsonNode node = new ObjectMapper().readTree(jsonStr);

    System.out.println("-------------add property dynamic------------");
    ((ObjectNode) node).with("extra").put("country", "China");

    System.out.println(node);
  }
}
