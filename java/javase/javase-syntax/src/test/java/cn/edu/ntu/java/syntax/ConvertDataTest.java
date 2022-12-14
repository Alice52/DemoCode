package cn.edu.ntu.java.syntax;

import cn.edu.ntu.java.javase.syntax.ConvertData;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author zack <br>
 * @create 2020-04-04 16:40 <br>
 */
@Slf4j
public class ConvertDataTest {

    @Test
    public void testConvertFromBytes() {

        String str = ConvertData.convert(new byte[] {1, 2, 'f', 'e', 'z'});
        log.info(str);
    }

    @Test
    public void testConvertFromStr() {

        byte[] bytes = ConvertData.convert("hhh");

        // byte nature is int8
        log.info(String.valueOf(bytes[0]));

        // this will log ClassName
        log.info(String.valueOf(bytes));

        // this will log String value
        log.info(new String(bytes));
    }

    @Test
    public void testChar2String() {
        String hello = StrUtil.str("hello", Charset.defaultCharset());
        char[] chars = hello.toCharArray();

        log.info(String.valueOf(chars[0]));
    }
}
