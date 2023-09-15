package cn.edu.ntu.java.javase.jvm.memory;

import java.lang.instrument.Instrumentation;

public class ObjectSizeCalculator {
    private static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object obj) {
        if (instrumentation == null) {
            throw new IllegalStateException("Instrumentation agent not initialized");
        }
        return instrumentation.getObjectSize(obj);
    }

    public static void main(String[] args) {

        String str = "Hello, world!";
        long size = getObjectSize(str);
        System.out.println("Size of the string: " + size + " bytes");
    }
}
