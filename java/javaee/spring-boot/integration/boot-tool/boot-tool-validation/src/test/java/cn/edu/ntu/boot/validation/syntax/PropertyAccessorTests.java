package cn.edu.ntu.boot.validation.syntax;

import lombok.ToString;
import org.junit.Test;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.PropertyAccessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-09-16 19:56 <br>
 * @project springboot <br>
 */
public class PropertyAccessorTests {

    /** use DirectFieldAccessor change property */
    @Test
    public void testUsageOfDirectFieldAccessor() {

        Apple apple = new Apple();

        PropertyAccessor accessor = new DirectFieldAccessor(apple);

        // 设置普通属性
        accessor.setPropertyValue("color", "红色");

        // 设置嵌套属性 [注意: 此处能够正常work是因为有 = new Size()]
        // 否则报错：NullValueInNestedPathException: Invalid property 'size' of bean class
        accessor.setPropertyValue("size.height", 10);

        // 设置集合/数组属性
        accessor.setPropertyValue("arrStr[0]", "a0");
        // 注意: 虽然初始化时初始化过数组了, 但是仍以此处的为准
        accessor.setPropertyValue("arrStr[1]", "a1");

        accessor.setPropertyValue("listStr[0]", "l0");
        // 如果角标index一样, 后面覆盖前面的
        accessor.setPropertyValue("listStr[0]", "l1");
        // Cannot convert value of type 'com.fsx.bean.Size' to required type 'java.lang.String'
        // accessor.setPropertyValue("listStr[0]", new Size());
        accessor.setPropertyValue("listStr[1]", 20);
        Object propertyValue = accessor.getPropertyValue("listStr[1]");
        System.out.println(Integer.parseInt(propertyValue.toString()));

        // 设置Map: key只能是数值才行, 否则是不好使的
        // Caused by: TypeMismatchException java.lang.NumberFormatException: For input string: "aaa"
        // accessor.setPropertyValue("map['aaa']","myValue1");
        accessor.setPropertyValue("map[1]", "myValue2");

        // 设置listList这种集合里的集合
        accessor.setPropertyValue("listList[0][0]", "listList00");
        accessor.setPropertyValue("listList[0][1]", "listList01");
        // IndexOutOfBoundsException: Index: 1, Size: 1
        // accessor.setPropertyValue("listList[1][0]","listList10");
        // IndexOutOfBoundsException: Index: 1, Size: 1
        // accessor.setPropertyValue("listList[1][1]","listList11");

        // 设置listMap这种集合里面放Map
        accessor.setPropertyValue("listMap[0][0]", "listMap00");
        // For input string: "myKey"
        // accessor.setPropertyValue("listMap[0]['myKey']","listMapkey");

        System.out.println(apple);
        // PropertyAccessorTests.Apple(color=红色, size=PropertyAccessorTests.Size(height=10,
        // width=null),
        // arrStr=[a0, a1], listStr=[l1], map={1=myValue2}, listList=[[listList00, listList01]],
        // listMap=[{0=listMap00}])

    }

    @ToString
    public class Apple {
        // no getter/setter
        private String color;

        // complex type
        private Size size = new Size();
        private String[] arrStr = new String[1];
        private List<String> listStr = new ArrayList<>();
        private Map<Integer, String> map = new HashMap<>();

        // nest list
        private List<List<String>> listList = new ArrayList<>();
        private List<Map<Integer, String>> listMap = new ArrayList<>();

        public Apple() {
            super();
            listList.add(new ArrayList<>());
            listMap.add(new HashMap<>());
        }
    }

    @ToString
    public class Size {
        private Integer height;
        private Integer width;
    }
}
