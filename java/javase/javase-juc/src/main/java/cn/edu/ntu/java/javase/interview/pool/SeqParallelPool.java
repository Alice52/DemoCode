package cn.edu.ntu.java.javase.interview.pool;

import com.github.phantomthief.pool.KeyAffinityExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author asd <br>
 * @create 2021-12-03 9:15 AM <br>
 * @project javase <br>
 */
@Slf4j
public class SeqParallelPool {

    /**
     * 原始需求: 富贵, 旺财各自独立运行, 但是需要保持各自的顺序
     */
    @Test
    public void targetLogic() {
        CoderDoSomeThing rich1 = new CoderDoSomeThing("富贵", "启动Idea");
        CoderDoSomeThing rich2 = new CoderDoSomeThing("富贵", "搞数据库,连tomcat,crud一顿输出");
        CoderDoSomeThing rich3 = new CoderDoSomeThing("富贵", "嘴角疯狂上扬");
        CoderDoSomeThing rich4 = new CoderDoSomeThing("富贵", "接口访问报错");
        CoderDoSomeThing rich5 = new CoderDoSomeThing("富贵", "心态崩了，卸载Idea");

        CoderDoSomeThing www1 = new CoderDoSomeThing("旺财", "启动Idea");
        CoderDoSomeThing www2 = new CoderDoSomeThing("旺财", "搞数据库,连tomcat,crud一顿输出");
        CoderDoSomeThing www3 = new CoderDoSomeThing("旺财", "嘴角疯狂上扬");
        CoderDoSomeThing www4 = new CoderDoSomeThing("旺财", "接口访问报错");
        CoderDoSomeThing www5 = new CoderDoSomeThing("旺财", "心态崩了，卸载Idea");
    }

    /**
     * 富贵, 旺财 确实在并行, 但是各自的顺序没有保证
     */
    @SneakyThrows
    @Test
    @Deprecated
    public void wrong() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<CoderDoSomeThing> coderDoSomeThingList = new ArrayList<>();

        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "心态崩了，卸载Idea"));

        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "心态崩了，卸载Idea"));

        coderDoSomeThingList.forEach(
                coderDoSomeThing ->
                        executorService.execute(() -> log.info(coderDoSomeThing.toString())));

        executorService.awaitTermination(1, TimeUnit.HOURS);
    }

    /**
     * 保证消费的顺序性: 一个线程的线程池<br>
     * 保证维度的并行: 每个维度都是一个线程池, Map 获取对应的执行线程池 <br>
     * 但是这样会有很多线程池, 并不是友好的解决方法, @KeyAffinityExecutor || dubbo 串行化
     */
    @SneakyThrows
    @Test
    public void right() {
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);

        HashMap<String, ExecutorService> executorServiceMap = new HashMap<>();
        executorServiceMap.put("富贵", executorService1);
        executorServiceMap.put("旺财", executorService2);
        List<CoderDoSomeThing> coderDoSomeThingList = new ArrayList<>();

        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing("富贵", "心态崩了，卸载Idea"));

        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing("旺财", "心态崩了，卸载Idea"));

        coderDoSomeThingList.forEach(
                coderDoSomeThing ->
                        executorServiceMap
                                .get(coderDoSomeThing.name)
                                .execute(() -> log.info(coderDoSomeThing.toString())));

        executorService1.awaitTermination(1, TimeUnit.HOURS);
    }

    @SneakyThrows
    @Test
    public void keyAffinity() {
        KeyAffinityExecutor executorService =
                KeyAffinityExecutor.newSerializingExecutor(3, 200, "MY-POOL-%d");
        List<CoderDoSomeThing> coderDoSomeThingList = new ArrayList<>();

        coderDoSomeThingList.add(new CoderDoSomeThing(1, "富贵", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing(1, "富贵", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing(1, "富贵", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing(1, "富贵", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing(1, "富贵", "心态崩了，卸载Idea"));

        coderDoSomeThingList.add(new CoderDoSomeThing(2, "旺财", "启动Idea"));
        coderDoSomeThingList.add(new CoderDoSomeThing(2, "旺财", "搞数据库,连tomcat,crud一顿输出"));
        coderDoSomeThingList.add(new CoderDoSomeThing(2, "旺财", "嘴角疯狂上扬"));
        coderDoSomeThingList.add(new CoderDoSomeThing(2, "旺财", "接口访问报错"));
        coderDoSomeThingList.add(new CoderDoSomeThing(2, "旺财", "心态崩了，卸载Idea"));

        ListenableFuture<CoderDoSomeThing> submit =
                executorService.submit(1, () -> new CoderDoSomeThing(1, "富贵", "启动Idea"));

        ListenableFuture<CoderDoSomeThing> submit1 =
                executorService.submit(
                        1,
                        () -> {
                            log.info("{}", submit.get());
                            return new CoderDoSomeThing(1, "富贵2", "启动Idea2");
                        });

        CoderDoSomeThing coderDoSomeThing = submit1.get();
        log.info("{}", coderDoSomeThing);
        TimeUnit.SECONDS.sleep(1);
    }

    @SneakyThrows
    @Test
    public void testCf() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture.completedFuture(new CoderDoSomeThing(2, "旺财", "心态崩了，卸载Idea"))
                .thenApplyAsync(
                        x -> {
                            log.info("{}", x);
                            return x + "---1";
                        },
                        executorService)
                .thenAcceptAsync(log::info, executorService)
                .thenAcceptAsync(x -> log.info("--{}", x), executorService)
                .join();
        TimeUnit.SECONDS.sleep(1);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class CoderDoSomeThing {
    int id;
    String name;
    String thing;

    public CoderDoSomeThing(String name, String thing) {
        this.name = name;
        this.thing = thing;
    }
}
