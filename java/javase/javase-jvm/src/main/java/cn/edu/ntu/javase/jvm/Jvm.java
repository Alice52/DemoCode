package cn.edu.ntu.javase.jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-04-04 23:40 <br>
 */
public class Jvm {
    private static final Logger LOG = LoggerFactory.getLogger(Jvm.class);

    /**
     * 21:50:11.525 [main] INFO JVM - Machine core number: 8 21:50:11.531 [main] INFO JVM -
     * [-Xms]JVM init memory 981 Mb 21:50:11.531 [main] INFO JVM - [-Xmx]JVM max memory 981 Mb Heap
     * PSYoungGen total 305664K, used 26214K [0x00000000eab00000, 0x0000000100000000,
     * 0x0000000100000000) eden space 262144K, 10% used
     * [0x00000000eab00000,0x00000000ec499b38,0x00000000fab00000) from space 43520K, 0% used
     * [0x00000000fd580000,0x00000000fd580000,0x0000000100000000) to space 43520K, 0% used
     * [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000) ParOldGen total 699392K, used 0K
     * [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000) object space 699392K, 0% used
     * [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000) Metaspace used 4830K, capacity
     * 5056K, committed 5248K, reserved 1056768K class space used 534K, capacity 560K, committed
     * 640K, reserved 1048576K
     */
    public static void main(String[] args) {
        LOG.info(
                "Machine core number: {}",
                String.valueOf(Runtime.getRuntime().availableProcessors()));
        LOG.info(
                "[-Xms]JVM init memory {} Mb",
                String.valueOf(Runtime.getRuntime().totalMemory() / 1024 / 1024));
        LOG.info(
                "[-Xmx]JVM max memory {} Mb",
                String.valueOf(Runtime.getRuntime().maxMemory() / 1024 / 1024));
    }
}
