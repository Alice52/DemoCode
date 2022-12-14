package cn.edu.ntu.java.javase.jhm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2020-09-09 00:05 <br>
 * @project javase <br>
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JmhCompilerControl {

    public static void main(String[] args) throws RunnerException {
        Options opt =
                new OptionsBuilder()
                        .include(JmhCompilerControl.class.getSimpleName())
                        .warmupIterations(0)
                        .measurementIterations(3)
                        .forks(1)
                        .build();

        new Runner(opt).run();
    }

    public void targetBlank() {
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void targetDontInline() {
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    public void targetInline() {
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public void dontInline() {
        targetDontInline();
    }

    @Benchmark
    public void inline() {
        targetInline();
    }
}
