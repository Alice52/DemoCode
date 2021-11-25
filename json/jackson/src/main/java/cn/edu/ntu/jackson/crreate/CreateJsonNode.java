package cn.edu.ntu.jackson.crreate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author asd <br>
 * @create 2021-11-25 5:46 PM <br>
 * @project json <br>
 */
@Slf4j
public class CreateJsonNode {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void prepareBody() {

        ObjectNode root = objectMapper.createObjectNode();
        root.set("HEADER_PARAM_MAP", objectMapper.createObjectNode());

        ObjectNode pathVariableNode = objectMapper.createObjectNode();
        pathVariableNode.set("ORGANIZATION_ID", pathVariableNode.textNode("text"));
        root.set("PATH_VARIABLE_MAP", pathVariableNode);

        root.set("age", root.numberNode(10));

        log.info("json value: {}", root.toString());
    }
}
