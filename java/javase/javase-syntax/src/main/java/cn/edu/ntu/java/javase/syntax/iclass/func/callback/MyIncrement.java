package cn.edu.ntu.java.javase.syntax.iclass.func.callback;

public class MyIncrement {
    static void f(MyIncrement f) {
        f.increment();
    }

    public void increment() {
        System.out.println("Other increment()");
    }
}
