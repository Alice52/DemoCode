package cn.edu.ntu.jackson;

import cn.edu.ntu.json.model.User;
import cn.edu.ntu.json.model.UserTreeNode;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author zack <br>
 * @create 2020-09-07 22:04 <br>
 * @project json <br>
 */
public class UserObjectCodec extends ObjectCodec {

    @Override
    public Version version() {
        return null;
    }

    @SneakyThrows
    @Override
    public <T> T readValue(JsonParser jsonParser, Class<T> aClass) throws IOException {

        User user = (User) aClass.newInstance();

        // 只要还没结束"}"，就一直读
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            if ("name".equals(fieldName)) {
                jsonParser.nextToken();
                user.setName(jsonParser.getText());
            } else if ("age".equals(fieldName)) {
                jsonParser.nextToken();
                user.setAge(jsonParser.getIntValue());
            }
        }

        return (T) user;
    }

    @Override
    public <T> T readValue(JsonParser jsonParser, TypeReference<T> typeReference)
            throws IOException {
        return null;
    }

    @Override
    public <T> T readValue(JsonParser jsonParser, ResolvedType resolvedType) throws IOException {
        return null;
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> aClass) throws IOException {
        return null;
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser jsonParser, TypeReference<T> typeReference)
            throws IOException {
        return null;
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser jsonParser, ResolvedType resolvedType)
            throws IOException {
        return null;
    }

    @Override
    public void writeValue(JsonGenerator gen, Object value) throws IOException {
        User user = null;
        if (value instanceof User) {
            user = User.class.cast(value);
        } else if (value instanceof TreeNode) {
            user = UserTreeNode.class.cast(value).getUser();
        }

        gen.writeStartObject();
        gen.writeStringField("name", user.getName());
        gen.writeNumberField("age", user.getAge());
        gen.writeEndObject();
    }

    @Override
    public <T extends TreeNode> T readTree(JsonParser jsonParser) throws IOException {
        return null;
    }

    @Override
    public void writeTree(JsonGenerator jsonGenerator, TreeNode treeNode) throws IOException {}

    @Override
    public TreeNode createObjectNode() {
        return null;
    }

    @Override
    public TreeNode createArrayNode() {
        return null;
    }

    @Override
    public JsonParser treeAsTokens(TreeNode treeNode) {
        return null;
    }

    @Override
    public <T> T treeToValue(TreeNode treeNode, Class<T> aClass) throws JsonProcessingException {
        return null;
    }
}
