package cn.edu.ntu.javase.enumeration.usage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * - thread safe; <br>
 * - no recommend; <br>
 * - it takes more than twice memory compared to the static constant usage. <br>
 *
 * @author zack <br>
 * @create 2020-01-31 19:02 <br>
 */
public class SingletonUsageTest {
    private static final Logger LOG = LoggerFactory.getLogger(SingletonUsageTest.class);

    private final DateConverter<LocalDateTime, String> converter1 = Date2StringConverters.yyyy_MM_dd;
    private final DateConverter<LocalDateTime, String> converter2 =
            Date2StringConverters.yyyy_MM_dd_HH_mm_ss;
    private final DateConverter<LocalDateTime, String> converter3 = Date2StringConverters.HH_mm_ss;

    @Test
    public void formatTest() {
        LocalDateTime date = LocalDateTime.now();
        LOG.info(converter1.convert(date));
        LOG.info(converter2.convert(date));
        LOG.info(converter3.convert(date));
    }
}

enum Date2StringConverters implements DateConverter<LocalDateTime, String> {
    /** */
    yyyy_MM_dd("yyyy-MM-dd"),
    /** */
    yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
    /** */
    HH_mm_ss("HH:mm:ss");
    private final String dateFormat;

    Date2StringConverters(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String convert(LocalDateTime source) {

        return DateTimeFormatter.ofPattern(dateFormat).format(source);
    }
}

interface DateConverter<S, T> {
    /**
     * convert S to T
     *
     * @param source
     * @return T
     */
    T convert(S source);
}
