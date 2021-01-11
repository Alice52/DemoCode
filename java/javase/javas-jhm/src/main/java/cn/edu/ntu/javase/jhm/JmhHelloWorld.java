package cn.edu.ntu.javase.jhm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 每个方法执行前都进行5次预热执行: 每隔1秒进行一次预热操作
 *
 * <p>预热执行结束之后进行5次实际测量执行: 每隔1秒进行一次实际执行, 基准测试测量的是平均响应时长[单位是us]
 *
 * @author zack <br>
 * @create 2020-09-08 23:07 <br>
 * @project javase <br>
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class JmhHelloWorld {
  static List<Demo> demoList;

  static {
    demoList = new ArrayList();
    for (int i = 0; i < 10000; i++) {
      demoList.add(new Demo(i, "test"));
    }
  }

  public static void main(String[] args) throws RunnerException {
    Options opt =
        new OptionsBuilder().include(JmhHelloWorld.class.getSimpleName()).forks(1).build();

    new Runner(opt).run();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void testHashMapWithoutSize() {
    Map map = new HashMap();
    for (Demo demo : demoList) {
      map.put(demo.id, demo.name);
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void testHashMap() {
    Map map = new HashMap((int) (demoList.size() / 0.75f) + 1);
    for (Demo demo : demoList) {
      map.put(demo.id, demo.name);
    }
  }

  static class Demo {
    int id;
    String name;

    public Demo(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
