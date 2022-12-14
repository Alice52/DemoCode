package cn.edu.ntu.java.javase.jvm.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zack <br>
 * @create 2022-03-20 20:48 <br>
 */
public class PaddedAtomicLong extends AtomicLong {
    private static final long serialVersionUID = -3415778863941386253L;

    /**
     * todo: should fill 5*long? <br>
     * Padded 6 long (48 bytes)
     */
    public volatile long p1, p2, p3, p4, p5 = 7L;

    /** Constructors from {@link AtomicLong} */
    public PaddedAtomicLong() {
        super();
    }

    public PaddedAtomicLong(long initialValue) {
        super(initialValue);
    }

    /** To prevent GC optimizations for cleaning unused padded references */
    public long sumPaddingToPreventOptimization() {
        return p1 + p2 + p3 + p4 + p5;
    }
}
