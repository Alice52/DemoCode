package cn.edu.ntu.java.javase.syntax.iclass.func.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zack Zhang
 */
@Slf4j
public class Callee extends MyIncrement {
    private int i = 0;

    private void incr() {
        i++;
        log.info("{}", i);
    }

    private class Closure implements Incrementable {
        public void increment() {
            incr();
        }
    }

    public Incrementable getCallbackReference() {
        return new Closure();
    }

    public static void main(String[] args) {
        Callee callee = new Callee();
        callee.increment();
        Incrementable callbackReference = callee.getCallbackReference();
        callbackReference.increment();
    }
}
