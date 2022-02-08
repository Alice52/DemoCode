package org.springframework.core.convert.support;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author asd <br>
 * @create 2022-02-08 10:55 AM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class ConverterFactoryTests {

    @Test
    public void testStringToNumberConverterFactory() {
        ConverterFactory<String, Number> converterFactory = new StringToNumberConverterFactory();
        // 不能写基本数据类型: int.class 将抛错
        converterFactory.getConverter(Integer.class).convert("1").getClass();
        converterFactory.getConverter(Double.class).convert("1.1").getClass();
        converterFactory.getConverter(Byte.class).convert("0x11").getClass();
    }
}
