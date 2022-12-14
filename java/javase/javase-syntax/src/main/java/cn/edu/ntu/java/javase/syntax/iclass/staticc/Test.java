package cn.edu.ntu.java.javase.syntax.iclass.staticc;

import lombok.val;

public class Test {
    public static void main(String[] args) {
        val a = OuterClass.InnerClass.sp;
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.accessOp();
        int ip = inner.getIp();
    }
}
