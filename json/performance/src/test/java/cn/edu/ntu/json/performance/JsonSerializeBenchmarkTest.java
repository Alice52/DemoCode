package cn.edu.ntu.json.performance;

import cn.edu.ntu.json.model.FullName;
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

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark (count) Mode Cnt Score Error Units JsonSerializeBenchmarkTest.FastJson 1000 ss 0.264
 * s/op JsonSerializeBenchmarkTest.FastJson 10000 ss 0.604 s/op JsonSerializeBenchmarkTest.FastJson
 * 100000 ss 1.212 s/op JsonSerializeBenchmarkTest.Gson 1000 ss 0.148 s/op
 * JsonSerializeBenchmarkTest.Gson 10000 ss 0.339 s/op JsonSerializeBenchmarkTest.Gson 100000 ss
 * 1.639 s/op JsonSerializeBenchmarkTest.Jackson 1000 ss 0.347 s/op
 * JsonSerializeBenchmarkTest.Jackson 10000 ss 0.404 s/op JsonSerializeBenchmarkTest.Jackson 100000
 * ss 0.768 s/op
 *
 * @author zack <br>
 * @create 2020-09-07 21:22 <br>
 * @project json <br>
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonSerializeBenchmarkTest {
    @Param({"1000", "10000", "100000"})
    private int count;

    private Person p;

    public static void main(String[] args) throws Exception {
        Options opt =
                new OptionsBuilder()
                        .include(JsonSerializeBenchmarkTest.class.getSimpleName())
                        .forks(1)
                        .warmupIterations(0)
                        .build();
        Collection<RunResult> results = new Runner(opt).run();

        results.forEach(x -> System.out.println(JSONUtil.toJsonStr(x)));
    }

    @Setup
    public void prepare() {
        List<Person> friends = new ArrayList<Person>();
        friends.add(createAPerson("alice", null));
        friends.add(createAPerson("Tony", null));
        friends.add(createAPerson("dylan", null));
        p = createAPerson("timothy", friends);
    }

    @TearDown
    public void shutdown() {}

    @Benchmark
    public void Gson() {
        for (int i = 0; i < count; i++) {
            GsonUtils.bean2Json(p);
        }
    }

    @Benchmark
    public void FastJson() {
        for (int i = 0; i < count; i++) {
            FastJsonUtils.bean2Json(p);
        }
    }

    @Benchmark
    public void Jackson() {
        for (int i = 0; i < count; i++) {
            JacksonUtils.bean2Json(p);
        }
    }

    private Person createAPerson(String name, List<Person> friends) {
        Person newPerson = new Person();
        newPerson.setName(name);
        newPerson.setFullName(new FullName("zack", "zhang", "zhuang"));
        newPerson.setAge(24);
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("basketball");
        hobbies.add("swimming");
        hobbies.add("coding");
        newPerson.setHobbies(hobbies);
        Map<String, String> clothes = new HashMap<String, String>();
        clothes.put("coat", "Nike");
        clothes.put("trousers", "adidas");
        clothes.put("shoes", "anta");
        newPerson.setClothes(clothes);
        newPerson.setFriends(friends);

        return newPerson;
    }
}
