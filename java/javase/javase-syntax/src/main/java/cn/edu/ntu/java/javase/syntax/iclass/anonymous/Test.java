package cn.edu.ntu.java.javase.syntax.iclass.anonymous;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class Test {

    int a;

    public void anonymousClassTest() {
        // this just define implements and it will not execute besides call interface method.
        AnonymousInterface anonymousInterface =
                new AnonymousInterface() {
                    // can define property in anonymous class，and can only used in local.
                    int field = a;

                    @Override
                    public void accept(String tag, Consumer consumer) {
                        consumer.accept(tag);
                    }
                };

        // create anonymous for each interface method call.
        anonymousInterface.accept("obj1", (Object a) -> log.info(a.toString()));
        anonymousInterface.accept("obj3", a -> log.info(a.toString()));
    }
}
