package cn.edu.ntu.java.javase.syntax;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * @author zack <br>
 * @create 2020-04-04 18:26 <br>
 */
public class InnerClassTest {
    private static final Logger LOG = LoggerFactory.getLogger(InnerClassTest.class);
    private int outerFiled = 10;

    public InnerClassTest() {
        LOG.info("create " + this.getClass().getSimpleName() + " Object.");
        CommonInner commonInner = new CommonInner();
        LOG.info("common inner class filed: " + commonInner.field1);

        StaticInner staticInner = new StaticInner();
        LOG.info("Static inner class filed: " + staticInner.field1);
    }

    @Test
    public void testCommonInner() {
        InnerClassTest innerClassTest = new InnerClassTest();
        // TODO: what is the different between the two class?
        CommonInner commonInner = innerClassTest.new CommonInner();
        CommonInner commonInner2 = new CommonInner();
    }

    @Test
    public void testStaticInner() {
        // There are no difference between the two class.
        StaticInner staticInner = new InnerClassTest.StaticInner();
        StaticInner staticInner2 = new StaticInner();
    }

    @Test
    public void anonymousClassTest() {
        // this just define implements and it will not execute besides call interface method.
        AnonymousInterface anonymousInterface =
                new AnonymousInterface() {
                    // can define property in anonymous class，and can only used in local.
                    int field = 1;

                    @Override
                    public void accept(String tag, Consumer consumer) {
                        consumer.accept(tag);
                        LOG.info("Outer class field2: " + outerFiled);
                    }
                };

        // create anonymous for each interface method call.
        anonymousInterface.accept("obj1", (Object a) -> LOG.info(a.toString()));
        anonymousInterface.accept("obj3", a -> LOG.info(a.toString()));
    }

    /**
     * type3: anonymous inner class <br>
     * 1. anonymous in known as implements interface as parameter. <br>
     * 2. anonymous inner class have all access to outer class. <br>
     * 3. outer class have a no access to anonymous inner class: <br>
     * - anonymous inner class can define property，and can only used in local, <br>
     * - and cannot used in outer class due to no class name.<br>
     * 4. even cannot create or get anonymous instance.<br>
     * 5. anonymous just define implements and it will not execute besides call interface method.
     * <br>
     * 6. create anonymous for each interface method call.<br>
     */
    interface AnonymousInterface {
        void accept(String tag, Consumer consumer);
    }

    /**
     * type2: static inner class <br>
     * 1. exist not depend on outer class. <br>
     * 2. static inner class have no access to outer class, in addition to static member. <br>
     * 3. outer class have access to all member of static inner class. <br>
     * 4. static inner class can also used to new instance. <br>
     * 5. static inner class can define un-static and static member. <br>
     */
    static class StaticInner {
        static int field5 = 5;
        // can define static member in static inner class
        public int field1 = 1;

        public StaticInner() {
            LOG.info("create " + StaticInner.class.getSimpleName() + " Object.");
            // LOG.info("InnerClassTest[outer] field1: " + field1); // compile error
        }
    }

    /**
     * type1: common inner class. <br>
     * 1. exist depending on outer class objects. <br>
     * 2. common inner class have access to all member of outer class. <br>
     * 3. outer class have access to all member of common inner class. <br>
     * 4. common inner class do not have static member. <br>
     */
    public class CommonInner {
        private int field1 = 20;

        // compile error: common inner class do not have static member
        // static int field5 = 5;

        public CommonInner() {
            LOG.info("create " + this.getClass().getSimpleName() + " Object.");
        }
    }
}
