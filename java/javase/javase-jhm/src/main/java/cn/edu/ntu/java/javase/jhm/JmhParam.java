package cn.edu.ntu.java.javase.jhm;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author zack <br>
 * @create 2020-09-08 23:45 <br>
 * @project javase <br>
 */
@State(Scope.Benchmark)
public class JmhParam {
    @Param({"1", "2", "3"})
    int testNum;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JmhParam.class.getSimpleName()).forks(1).build();

        new Runner(opt).run();
    }

    @Benchmark
    public String test() {
        return String.valueOf(testNum);
    }
}
