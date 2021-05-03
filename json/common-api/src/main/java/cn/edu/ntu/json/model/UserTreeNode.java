package cn.edu.ntu.json.model;

import com.fasterxml.jackson.core.*;

import java.util.Iterator;

/**
 * @author zack <br>
 * @create 2020-09-07 23:39 <br>
 * @project json <br>
 */
public class UserTreeNode implements TreeNode {

    private User user;

    public UserTreeNode(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public JsonToken asToken() {
        return null;
    }

    @Override
    public JsonParser.NumberType numberType() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isValueNode() {
        return false;
    }

    @Override
    public boolean isContainerNode() {
        return false;
    }

    @Override
    public boolean isMissingNode() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isObject() {
        return false;
    }

    @Override
    public TreeNode get(String s) {
        return null;
    }

    @Override
    public TreeNode get(int i) {
        return null;
    }

    @Override
    public TreeNode path(String s) {
        return null;
    }

    @Override
    public TreeNode path(int i) {
        return null;
    }

    @Override
    public Iterator<String> fieldNames() {
        return null;
    }

    @Override
    public TreeNode at(JsonPointer jsonPointer) {
        return null;
    }

    @Override
    public TreeNode at(String s) throws IllegalArgumentException {
        return null;
    }

    @Override
    public JsonParser traverse() {
        return null;
    }

    @Override
    public JsonParser traverse(ObjectCodec objectCodec) {
        return null;
    }
}
