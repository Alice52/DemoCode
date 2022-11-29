package cn.edu.ntu.javase.syntax.iclass.localc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OuterClass {
    public int op;

    public void getXx() {
        int mp = 1;

        final class LocalInner {
            public int ip;

            public void getX() {
                log.info("{}-{}-{}", op, mp, ip);
            }
        }
    }
}
