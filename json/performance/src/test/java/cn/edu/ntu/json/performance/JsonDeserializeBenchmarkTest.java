package cn.edu.ntu.json.performance;

import cn.edu.ntu.json.model.Person;
import cn.edu.ntu.json.util.FastJsonUtils;
import cn.edu.ntu.json.util.GsonUtils;
import cn.edu.ntu.json.util.JacksonUtils;
import cn.hutool.json.JSONUtil;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
    Benchmark                              (count)  Mode  Cnt  Score   Error  Units
    JsonDeserializeBenchmarkTest.FastJson     1000    ss       0.315           s/op
    JsonDeserializeBenchmarkTest.FastJson    10000    ss       0.386           s/op
    JsonDeserializeBenchmarkTest.FastJson   100000    ss       1.323           s/op
    JsonDeserializeBenchmarkTest.Gson         1000    ss       0.156           s/op
    JsonDeserializeBenchmarkTest.Gson        10000    ss       0.282           s/op
    JsonDeserializeBenchmarkTest.Gson       100000    ss       0.995           s/op
    JsonDeserializeBenchmarkTest.Jackson      1000    ss       0.423           s/op
    JsonDeserializeBenchmarkTest.Jackson     10000    ss       0.474           s/op
    JsonDeserializeBenchmarkTest.Jackson    100000    ss       1.070           s/op
 *
 * @author zack <br>
 * @create 2020-09-07 21:48 <br>
 * @project json <br>
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonDeserializeBenchmarkTest {
  @Param({"1000", "10000", "100000"})
  private int count;

  private String jsonStr;

  public static void main(String[] args) throws Exception {
    Options opt =
        new OptionsBuilder()
            .include(JsonDeserializeBenchmarkTest.class.getSimpleName())
            .forks(1)
            .warmupIterations(0)
            .build();
    Collection<RunResult> results = new Runner(opt).run();

    results.forEach(x -> System.out.println(JSONUtil.toJsonStr(x)));
  }

  @Setup
  public void prepare() {
    jsonStr =
        "{\"name\":\"邵同学\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":[{\"name\":\"小明\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"Tony\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"陈小二\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null}]}";
  }

  @TearDown
  public void shutdown() {}

  @Benchmark
  public void Gson() {
    for (int i = 0; i < count; i++) {
      GsonUtils.json2Bean(jsonStr, Person.class);
    }
  }

  @Benchmark
  public void FastJson() {
    for (int i = 0; i < count; i++) {
      FastJsonUtils.json2Bean(jsonStr, Person.class);
    }
  }

  @Benchmark
  public void Jackson() {
    for (int i = 0; i < count; i++) {
      JacksonUtils.json2Bean(jsonStr, Person.class);
    }
  }
}
