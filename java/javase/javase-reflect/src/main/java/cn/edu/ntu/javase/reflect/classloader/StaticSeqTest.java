package cn.edu.ntu.javase.reflect.classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * new start <br>
 * C1 <br>
 * new end <br>
 * Class.forName start <br>
 * C2 <br>
 * Class.forName end <br>
 * C3.class start <br>
 * C3.class end <br>
 * c1.newInstance start <br>
 * C3 <br>
 * c1.newInstance end <br>
 *
 * @author zack <br>
 * @create 2020-02-10 18:19 <br>
 */
public class StaticSeqTest {
    private static final Logger LOG = LoggerFactory.getLogger(StaticSeqTest.class);

    public static void main(String... args) throws Exception {
        LOG.info("new start");
        // Constructor is a static reference to the class, triggering Type loading
        new C1();
        new C1();
        LOG.info("new end");

        LOG.info("Class.forName start");
        // Class.forName is a static function on Class, used to force the loading of Class
        Class.forName("cn.edu.ntu.javase.reflect.classloader.StaticSeqTest$C2");
        Class.forName("cn.edu.ntu.javase.reflect.classloader.StaticSeqTest$C2");
        LOG.info("Class.forName end");

        LOG.info("C3.class start");
        // Class reference, will trigger Class loading, but will not trigger initialization
        Class c1 = C3.class;
        Class c2 = C3.class;
        LOG.info("C3.class end");

        LOG.info("c1.newInstance start");
        // Invoke methods on the class to trigger initialization logic
        c1.newInstance();
        LOG.info("c1.newInstance end");
    }

    static class C1 {
        static {
            LOG.info("C1");
        }
    }

    static class C2 {
        static {
            LOG.info("C2");
        }
    }

    static class C3 {
        static {
            LOG.info("C3");
        }
    }
}
