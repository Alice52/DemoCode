package cn.edu.ntu.javase.jhm;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author zack <br>
 * @create 2020-09-08 23:55 <br>
 * @project javase <br>
 */
public class JmhBlackhole {

  static int x1 = 10, x2 = 20;

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(JmhBlackhole.class.getSimpleName()).forks(1).build();

    new Runner(opt).run();
  }

  /**
   * 返回测试结果, 防止编译器优化
   *
   * @return
   */
  @Benchmark
  public double measureRight1() {
    return Math.log(x1) + Math.log(x2);
  }

  /**
   * 通过 Blackhole 消费中间结果, 防止编译器优化
   *
   * @param bh
   */
  @Benchmark
  public void measureRight2(Blackhole bh) {
    bh.consume(Math.log(x1));
    bh.consume(Math.log(x2));
  }
}
