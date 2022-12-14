package cn.edu.ntu.java.javase.interview.cf;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static cn.hutool.core.lang.Validator.isUpperCase;
import static java.util.concurrent.CompletableFuture.allOf;
import static java.util.concurrent.CompletableFuture.completedFuture;
import static org.junit.Assert.*;

/**
 * CompletableFuture
 *
 * <pre>
 *     1. cf.get() 有性能问题, 尽量使用 get(long timeout, TimeUnit unit)
 *     2. accept 可以接受参数; run 不可以接收参数没有返回值; apply 能接受且有返回值
 *     3. handle 就像 finally, 不论正常返回还是出异常都会进入handle, 类似whenComplete
 *          - whenComplete
 *          - handle
 *          - exceptionally
 *     4. 被组合的是异步的则需要 join， cf.getNow(null) 得到的就是 null
 *     5. compose 流水线操作, 完成后执行下一个; combine 合并两个完成的之后执行任务
 *     6. allOf and anyOf
 * </pre>
 *
 * @author asd <br>
 * @create 2021-10-12 9:40 AM <br>
 * @project javase <br>
 */
@Slf4j
@SuppressWarnings("unchecked")
public class CompletableFutureTests {
    private static String delayedUpperCase(String x) {
        long threadId = Thread.currentThread().getId();
        log.info("delayedUpperCase thread id: {}", threadId);
        randomSleep(1_000);
        return x.toUpperCase();
    }

    @SneakyThrows
    private static void randomSleep(long millis) {
        Thread.sleep(millis);
    }

    public static void main(String[] args) {
        CompletableFuture.completedFuture(Arrays.asList("a", "b"))
                .thenCompose(
                        cars -> {
                            List<CompletionStage> updatedCars = new ArrayList<>(10);
                            CompletableFuture done =
                                    allOf(updatedCars.toArray(new CompletableFuture[0]));
                            return done.thenApply(
                                    v ->
                                            updatedCars.stream()
                                                    .map(CompletionStage::toCompletableFuture)
                                                    .map(CompletableFuture::join)
                                                    .collect(Collectors.toList()));
                        })
                .whenComplete(
                        (cars, th) -> {
                            if (th == null) {
                                throw new RuntimeException((String) th);
                            }
                        })
                .toCompletableFuture()
                .join();
    }

    @Test
    public void completedFutureExample() {
        CompletableFuture cf = completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals("message", cf.getNow(null));
    }

    @Test
    public void thenApplyExample() {
        CompletableFuture cf = completedFuture("message").thenApply(String::toUpperCase);
        assertEquals("MESSAGE", cf.getNow(null));
    }

    @Test
    public void runAsyncExample() {
        CompletableFuture cf =
                CompletableFuture.runAsync(
                        () -> {
                            assertTrue(Thread.currentThread().isDaemon());
                            randomSleep(100);
                            log.info("daemon thread: {}", Thread.currentThread().isDaemon());
                        });
        assertFalse(cf.isDone());
        randomSleep(2_000);
        assertTrue(cf.isDone());
    }

    @Test
    public void thenApplyAsyncExample() {
        CompletableFuture cf =
                completedFuture("message")
                        .thenApplyAsync(
                                s -> {
                                    assertTrue(Thread.currentThread().isDaemon());
                                    randomSleep(100);
                                    return s.toUpperCase();
                                });
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    @Test
    public void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        completedFuture("thenAccept message").thenAccept(result::append);
        log.info("{}", result);
        assertTrue("Result was not empty", result.length() > 0);
    }

    @Test
    public void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture cf =
                completedFuture("thenAcceptAsync message").thenAcceptAsync(result::append);
        cf.join();
        assertTrue("Result was empty", result.length() > 0);
    }

    @Test
    public void cancelExample() {
        CompletableFuture cf =
                completedFuture("message").thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture cf2 = cf.exceptionally(throwable -> "canceled message");
        assertTrue(cf.cancel(true));
        assertTrue(cf.isCompletedExceptionally());
        assertEquals("canceled message", cf2.join());
    }

    @Test
    public void applyToEitherExample() {
        String original = "Message";
        CompletableFuture<String> cf1 =
                completedFuture(original).thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture<String> cf2 =
                completedFuture(original).thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture<String> cf3 = cf1.applyToEither(cf2, s -> s + " from applyToEither");
        assertTrue(cf3.join().endsWith(" from applyToEither"));
    }

    @Test
    public void acceptEitherExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture<String> cf1 =
                completedFuture(original).thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture<String> cf2 =
                completedFuture(original).thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture cf = cf1.acceptEither(cf2, s -> result.append(s).append("acceptEither"));
        cf.join();
        assertTrue("Result was empty", result.toString().endsWith("acceptEither"));
    }

    @Test
    public void runAfterBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        val cf1 = completedFuture(original).thenApply(String::toUpperCase);
        CompletableFuture<String> cf2 = completedFuture(original).thenApply(String::toLowerCase);
        cf1.runAfterBoth(cf2, () -> result.append("done"));
        assertTrue("Result was empty", result.length() > 0);
    }

    @Test
    public void thenAcceptBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture<String> cf1 = completedFuture(original).thenApply(String::toUpperCase);
        CompletableFuture<String> cf2 = completedFuture(original).thenApply(String::toLowerCase);
        cf1.thenAcceptBoth(cf2, (s1, s2) -> result.append(s1).append(s2));
        assertEquals("MESSAGEmessage", result.toString());
    }

    @Test
    public void thenCombineExample() {
        String original = "Message";
        CompletableFuture<String> cf1 =
                completedFuture(original).thenApply(CompletableFutureTests::delayedUpperCase);
        CompletableFuture<String> cf2 =
                completedFuture(original).thenApply(CompletableFutureTests::delayedUpperCase);
        CompletableFuture cf = cf1.thenCombine(cf2, (s1, s2) -> s1 + s2);
        assertEquals("MESSAGEMESSAGE", cf.getNow(null));
    }

    @Test
    public void thenCombineAsyncExample() {
        String original = "Message";
        CompletableFuture<String> cf1 =
                completedFuture(original).thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture<String> cf2 =
                completedFuture(original).thenApplyAsync(CompletableFutureTests::delayedUpperCase);
        CompletableFuture cf = cf1.thenCombine(cf2, (s1, s2) -> s1 + s2);
        cf.join();
        assertEquals("MESSAGEMESSAGE", cf.getNow(null));
    }

    @Test
    public void thenComposeExample() {
        String original = "Message";
        CompletableFuture<String> cf1 =
                completedFuture(original).thenApply(CompletableFutureTests::delayedUpperCase);
        CompletableFuture<String> cf2 =
                completedFuture(original).thenApply(CompletableFutureTests::delayedUpperCase);
        CompletableFuture cf = cf1.thenCompose(upper -> cf2.thenApply(s -> upper + s));
        assertEquals("MESSAGEMESSAGE", cf.getNow(null));
    }

    @Test
    public void anyOfExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures =
                messages.stream()
                        .map(
                                msg ->
                                        completedFuture(msg)
                                                .thenApply(CompletableFutureTests::delayedUpperCase)
                                                .whenComplete((res, th) -> result.append(res)))
                        .collect(Collectors.toList());

        // anyOf whenComplete 会返回某个Future的结果: ABCA
        // allOf whenComplete 返回 null: ABC
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete((res, th) -> result.append(res))
                .join();

        assertTrue("Result was empty", result.length() > 0);
        assertEquals("ABCA", result.toString());
    }

    @Test
    public void allOfExample() {
        long threadId = Thread.currentThread().getId();
        log.info("origin thread id: {}", threadId);

        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures =
                messages.stream()
                        .map(
                                msg ->
                                        completedFuture(msg)
                                                .thenApply(CompletableFutureTests::delayedUpperCase)
                                                .whenComplete((res, th) -> result.append(res)))
                        .collect(Collectors.toList());

        allOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete(
                        (v, th) -> {
                            futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
                            result.append("done");
                        });
        assertTrue("Result was empty", result.length() > 0);
        assertEquals("ABCdone", result.toString());
    }

    @Test
    public void allOfAsyncExample() {

        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures =
                messages.stream()
                        .map(
                                msg ->
                                        completedFuture(msg)
                                                .thenApplyAsync(
                                                        CompletableFutureTests::delayedUpperCase))
                        .collect(Collectors.toList());

        CompletableFuture allOf =
                allOf(futures.toArray(new CompletableFuture[0]))
                        .whenComplete(
                                (v, th) -> {
                                    futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
                                    result.append("done");
                                });

        allOf.join();
        assertTrue("Result was empty", result.length() > 0);
        assertEquals("done", result.toString());
    }

    @Test
    public void testThreadId() {
        allOfExample();
    }
}
