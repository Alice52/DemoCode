package cn.edu.ntu.java.javase.syntax.box;

import java.util.HashMap;
import java.util.Map;

/**
 * https://mp.weixin.qq.com/s?__biz=MzIzOTU0NTQ0MA==&mid=2247495631&idx=1&sn=ec3a23662a196b338dee29249d8cbb05
 *
 * @author zack <br>
 * @create 2021-04-11 13:03 <br>
 * @project javase <br>
 */
public class BoxTest {

    // 在小于 JDK 1.8 的版本中执行的结果是 NPE，在 JDK 1.8 及以后的版本中执行结果是 null
    // jdk7的推断能力比较弱, 推断不出:前后的类型, 所以会先拆箱再装箱
    // jdk8的推断能力比较强, 可以推断出类型是Boolean[泛型擦除之后的引用类型], 所以不会拆箱
    Map<String, Boolean> map = new HashMap<>();
    Boolean b = (map != null ? map.get("Hollis") : false);

    // NPE
    Integer i = null;
    Long a = 1 == 1 ? i : new Long(1);
}
