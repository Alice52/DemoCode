package cn.edu.ntu.java.javase.jhm;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * - usages
 *
 * <p>1. 直接在内部类中使用 @State 作为 "PropertyHolder"
 *
 * <p>2. 在 Main 类中直接使用 @State 作为注解, 是 Main 类直接成为 "PropertyHolder"
 *
 * <p>3. 被@Benchmark标注的方法可以有参数, 但是参数必须是被@State注解的, 就是为了要控制参数的隔离
 *
 * @author zack <br>
 * @create 2020-09-08 23:28 <br>
 * @project javase <br>
 */
// @State(Scope.Thread)
public class JmhStateOnInnerClass {

    public static void main(String[] args) throws RunnerException {
        Options opt =
                new OptionsBuilder()
                        .include(JmhStateOnInnerClass.class.getSimpleName())
                        .threads(4)
                        .forks(1)
                        .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void measureUnshared(ThreadState state) {
        state.x++;
    }

    @Benchmark
    public void measureShared(BenchmarkState state) {
        state.x++;
    }

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        volatile double x = Math.PI;
    }

    @State(Scope.Thread)
    public static class ThreadState {
        volatile double x = Math.PI;
    }
}
