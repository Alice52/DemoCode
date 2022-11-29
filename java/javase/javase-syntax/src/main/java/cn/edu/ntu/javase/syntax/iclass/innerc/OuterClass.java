package cn.edu.ntu.javase.syntax.iclass.innerc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class OuterClass {

    int a = 1;
    private int op;
    private static int sop;
    private InnerClass innerClass = new InnerClass();


    public class InnerClass {
        // inner class cannot contains static properties.
        // private static int p;
        int a = 2;
        private int ip;

        public void accessOp() {
            log.info("out class properties: {}-{}", op, sop);
        }

        public void method() {
            int a = 3;
            // 访问方法内部变量
            log.info("{}", a);
            // 访问内部类的成员变量
            log.info("{}", this.a);
            // 访问外部内的成员变量
            log.info("{}", OuterClass.this.a);
        }
    }
}
