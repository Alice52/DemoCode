package cn.edu.ntu.javase.syntax.object;

import cn.edu.ntu.javase.common.model.Address;
import cn.edu.ntu.javase.common.model.Employee;
import cn.hutool.core.lang.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author asd <br>
 * @create 2022-01-11 5:06 PM <br>
 * @project javase <br>
 */
@Slf4j
public class CloneTest {

    // *******************************************
    // 浅克隆
    // *******************************************

    public static <T> T deepClone(T object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            ByteArrayInputStream bais =
                    new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testShadowClone4Map() {
        HashMap<String, Address> map = new HashMap<>();
        map.put("xuzhou", new Address("xuzhou", "jiangsu"));
        map.put("nanjing", new Address("nanjing", "jiangsu"));

        HashMap<String, Address> clone = (HashMap<String, Address>) map.clone();
        Assert.isTrue(clone.get("nanjing") == map.get("nanjing"));
    }

    // *******************************************
    // 深克隆
    // *******************************************

    @Test
    public void testShadowClone4List() {
        ArrayList<Address> list = new ArrayList<>();
        list.add(new Address("xuzhou", "jiangsu"));
        list.add(new Address("nanjing", "jiangsu"));

        ArrayList<Address> clone = (ArrayList<Address>) list.clone();
        Assert.isTrue(clone.get(0) == list.get(0));
    }

    /** 需要 Address & Employee 实现序列化接口 */
    @Test
    public void whenModifyingOriginalObject_thenSerializableShouldNotChange() {

        Address address = new Address("xuzhou", "jiangsu");
        Employee pm = new Employee("zack", 18, 1000.0, address);

        Employee deepCopy = deepClone(pm);
        address.setCity("shanghai");

        Assert.isFalse(deepCopy.getAddress().getCity().equals(pm.getAddress().getCity()));
    }

    /** 不需要 Address & Employee 实现序列化接口 */
    @Test
    public void whenModifyingOriginalObject_thenGsonCloneShouldNotChange() {
        Address address = new Address("xuzhou", "jiangsu");
        Employee pm = new Employee("zack", 18, 1000.0, address);
        Gson gson = new Gson();
        Employee deepCopy = gson.fromJson(gson.toJson(pm), Employee.class);

        address.setCity("shanghai");

        Assert.isFalse(deepCopy.getAddress().getCity().equals(pm.getAddress().getCity()));
    }

    /**
     * 不需要 Address & Employee 实现序列化接口
     *
     * @throws IOException
     */
    @Test
    public void whenModifyingOriginalObject_thenJacksonCopyShouldNotChange() throws IOException {
        Address address = new Address("xuzhou", "jiangsu");
        Employee pm = new Employee("zack", 18, 1000.0, address);
        ObjectMapper objectMapper = new ObjectMapper();
        Employee deepCopy =
                objectMapper.readValue(objectMapper.writeValueAsString(pm), Employee.class);
        address.setCity("shanghai");
        Assert.isFalse(deepCopy.getAddress().getCity().equals(pm.getAddress().getCity()));
    }
}
