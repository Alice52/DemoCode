package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.generic.create.GenericsArray;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-22 15:22 <br>
 */
public class GenericsArrayTTest {

  private static final Logger LOG = LoggerFactory.getLogger(GenericsArray.class);

  @Test
  public void test() {
    GenericsArray<Integer> array = new GenericsArray<>(10);
    array.put(0, 1);
    array.put(4, 10);
    Arrays.stream(array.rap()).forEach(System.out::println);
    LOG.info(array.get(0) + "");
  }
}
