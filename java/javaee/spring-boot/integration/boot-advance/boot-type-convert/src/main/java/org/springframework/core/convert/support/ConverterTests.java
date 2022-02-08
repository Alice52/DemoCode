package org.springframework.core.convert.support;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.nio.charset.Charset;

/**
 * @author asd <br>
 * @create 2022-02-07 5:26 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class ConverterTests {

    /** 这里需要将包名改为和 StringToBooleanConverter 一样的 */
    @Test
    public void test() {
        /*
           - true  ||  false
           - on    ||  off
           - yes   ||  no
           - 1     ||  0
        */
        Converter<String, Boolean> converter = new StringToBooleanConverter();

        /*
            - uTf-8
            - utF8
        */
        Converter<String, Charset> converter2 = new StringToCharsetConverter();
    }
}
