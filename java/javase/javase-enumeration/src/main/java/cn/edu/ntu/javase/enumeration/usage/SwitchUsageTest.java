package cn.edu.ntu.javase.enumeration.usage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1. convert data to enum; <br>
 * 2. then use it in switch. <br>
 *
 * @author zack <br>
 * @create 2020-01-31 19:02 <br>
 */
public class SwitchUsageTest {
    private static final Logger LOG = LoggerFactory.getLogger(SwitchUsageTest.class);

    @Test
    public void testSwitchUsage() {

        LOG.info(nameByEnum(FruitEnum.BANANA));
        LOG.info(nameByEnum(FruitEnum.APPLE));
    }

    private String nameByEnum(FruitEnum fruit) {
        // convert data to enum
        // then use it in switch
        switch (fruit) {
            case APPLE:
                return "apple";
            case BANANA:
                return "banana";
            case PEAR:
                return "pear";
            default:
                return "unknown";
        }
    }
}

enum FruitEnum {
    APPLE,
    BANANA,
    PEAR
}
