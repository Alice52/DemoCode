package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2020-09-14 22:04 <br>
 * @project json <br>
 */
public class JsonNodeFactoryTests {

    @Test
    public void testValueNode() {
        JsonNodeFactory factory = JsonNodeFactory.instance;

        System.out.println("------ValueNode------");
        JsonNode node = factory.numberNode(1);
        System.out.println(node.isNumber() + ":" + node.intValue());

        node = factory.nullNode();
        System.out.println(node.isNull() + ":" + node.asText());

        node = factory.missingNode();
        System.out.println(node.isMissingNode() + "_" + node.asText());

        node = factory.pojoNode(new User("zack", 18));
        System.out.println(node.isPojo() + ":" + node.asText());

        System.out.println("---" + node.isValueNode() + "---");
    }

    @Test
    public void testContainerNode() {
        JsonNodeFactory factory = JsonNodeFactory.instance;

        System.out.println("------json------");
        ObjectNode rootNode = factory.objectNode();

        // same as: rootNode.set("zhName", factory.textNode("A哥"))
        rootNode.put("zhName", "zhang");
        rootNode.put("enName", "zack");
        rootNode.put("age", 18);

        ArrayNode arrayNode = factory.arrayNode().add("java").add("javascript").add("python");
        rootNode.set("languages", arrayNode);

        ObjectNode dogNode = factory.objectNode().put("name", "zack").put("age", 3);
        rootNode.set("dog", dogNode);

        System.out.println(rootNode);
        System.out.println(rootNode.get("dog").get("name"));
    }
}
