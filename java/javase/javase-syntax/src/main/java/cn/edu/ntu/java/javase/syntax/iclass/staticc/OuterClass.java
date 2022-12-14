package cn.edu.ntu.java.javase.syntax.iclass.staticc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OuterClass {
    private static int sop;
    int a = 1;
    private int op;
    private InnerClass innerClass = new InnerClass();

    @Data
    public static class InnerClass {
        static int sp;
        int a = 2;
        private int ip;

        public void accessOp() {
            log.info("out class properties: {}", sop);
        }

        public void method() {

            int a = 3;
            // 访问方法内部变量
            log.info("{}", a);
            // 访问内部类的成员变量
            log.info("{}", this.a);
            // 访问外部内的成员变量: error
            // log.info("{}", OuterClass.this.a);
        }
    }
}
