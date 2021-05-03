package cn.edu.ntu.javase.reflect.classapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author zack <br>
 * @create 2020-04-04 23:48 <br>
 */
public class AccessibleObjectTest {
    private static final Logger LOG = LoggerFactory.getLogger(AccessibleObjectTest.class);

    public static void main(String... args) throws Exception {
        TestBean testBean = new TestBean();
        // private
        Method setId = TestBean.class.getDeclaredMethod("setId", String.class);
        LOG.info("setId: " + setId.isAccessible());
        try {
            setId.invoke(testBean, "111");
        } catch (Exception e) {
            LOG.info("private can not be call success.");
        }
        setId.setAccessible(true);
        LOG.info("set accessible: " + setId.isAccessible());

        setId.invoke(testBean, "111");
        LOG.info("After set accessible to true and private limit" + testBean.getId());
    }
}

class TestBean {
    private String id;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
