package cn.edu.ntu.javase.jhm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-09-09 00:01 <br>
 * @project javase <br>
 */
@State(Scope.Thread)
public class JmhBatchSize {
  List<String> list = new LinkedList<>();

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(JmhBatchSize.class.getSimpleName()).forks(1).build();

    new Runner(opt).run();
  }

  /**
   * 每个 iteration 中做 5000 次Invocation
   *
   * @return
   */
  @Benchmark
  @Warmup(iterations = 5, batchSize = 5000)
  @Measurement(iterations = 5, batchSize = 5000)
  @BenchmarkMode(Mode.SingleShotTime)
  public List<String> measureRight() {
    list.add(list.size() / 2, "something");
    return list;
  }

  @Setup(Level.Iteration)
  public void setup() {
    list.clear();
  }
}
