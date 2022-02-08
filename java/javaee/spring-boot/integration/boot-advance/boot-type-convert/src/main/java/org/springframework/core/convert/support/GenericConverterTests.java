package org.springframework.core.convert.support;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author asd <br>
 * @create 2022-02-08 1:20 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class GenericConverterTests {
    @Test
    public void test3() {
        ConditionalGenericConverter conditionalGenericConverter =
                new CollectionToCollectionConverter(new DefaultConversionService());
        log.info("{}", conditionalGenericConverter.getConvertibleTypes());

        List<String> sourceList = Arrays.asList("1", "2", "2", "3", "4");
        TypeDescriptor sourceTypeDesp =
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class));
        TypeDescriptor targetTypeDesp =
                TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(Integer.class));

        log.info(
                "matches: {}", conditionalGenericConverter.matches(sourceTypeDesp, targetTypeDesp));
        Object convert =
                conditionalGenericConverter.convert(sourceList, sourceTypeDesp, targetTypeDesp);
        log.info("{}", convert.getClass());
        log.info("{}", convert);
    }

    @Test
    public void testStreamConverter() {
        ConditionalGenericConverter converter = new StreamConverter(new DefaultConversionService());

        TypeDescriptor sourceTypeDesp = TypeDescriptor.valueOf(Object[].class);
        TypeDescriptor targetTypeDesp = TypeDescriptor.valueOf(Stream.class);
        boolean matches = converter.matches(sourceTypeDesp, targetTypeDesp);
        log.info("{}", "是否能够转换：" + matches);

        // 执行转换
        Object convert = converter.convert(new Object[] {1}, sourceTypeDesp, targetTypeDesp);
        log.info("{}", convert);
        log.info("{}", Stream.class.isAssignableFrom(convert.getClass()));
    }

    @Test
    public void testStreamConverterV2() {
        ConversionService conversionService = new DefaultConversionService();
        Stream<Integer> result = conversionService.convert(Collections.singleton(1), Stream.class);

        result.forEach(System.out::println);
    }
}
