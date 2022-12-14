package cn.edu.ntu.java.javase.jhm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author zack <br>
 * @create 2020-09-08 23:38 <br>
 * @project javase <br>
 */
@State(Scope.Thread)
public class JmhSetupAndTearDown {
    double x;

    public static void main(String[] args) throws RunnerException {
        Options opt =
                new OptionsBuilder()
                        .include(JmhSetupAndTearDown.class.getSimpleName())
                        .forks(1)
                        .jvmArgs("-ea")
                        .build();

        new Runner(opt).run();
    }

    @Setup
    public void prepare() {
        x = Math.PI;
    }

    @TearDown
    public void check() {
        assert x > Math.PI : "Nothing changed?";
    }

    @Benchmark
    public void measureRight() {
        x++;
    }
}
