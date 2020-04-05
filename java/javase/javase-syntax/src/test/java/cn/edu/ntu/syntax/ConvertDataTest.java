package cn.edu.ntu.syntax;

import cn.edu.ntu.javase.syntax.ConvertData;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.stream.Stream;

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
