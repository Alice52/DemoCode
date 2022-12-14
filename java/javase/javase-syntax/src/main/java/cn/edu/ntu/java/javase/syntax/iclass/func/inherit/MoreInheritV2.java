package cn.edu.ntu.java.javase.syntax.iclass.func.inherit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MoreInheritV2 {

    private Example1 e1 = new Example1();
    private Example2 e2 = new Example2();

    public String name() {
        return e1.name();
    }

    public String age() {
        return e2.address();
    }

    public static void main(String args[]) {
        MoreInheritV2 mi = new MoreInheritV2();
        log.info("姓名:" + mi.name());
        log.info("地址:" + mi.age());
    }
}
