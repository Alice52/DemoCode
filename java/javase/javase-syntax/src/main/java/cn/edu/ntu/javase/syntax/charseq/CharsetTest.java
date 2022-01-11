package cn.edu.ntu.javase.syntax.charseq;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.SortedMap;

/**
 * @author zack <br>
 * @create 2020-04-04 17:45 <br>
 */
@Slf4j
public class CharsetTest {

    /**
     * 功能: 测试编码解码的问题 <br>
     * 1.notice: 这里的flip()的使用: <br>
     * 只有在使用put()之后采取去掉用, 而编码解码这里是不需要调用flip()的 <br>
     */
    @Test
    public void testCharset2() {
        try {
            // 1. 创建码的方式
            Charset cs = Charset.forName(Charset.defaultCharset().name());

            // 2. 创建 Buffer, 并放入数据
            CharBuffer charBuffer = CharBuffer.allocate(1024);
            charBuffer.put("Hello Charset".toCharArray());

            // 3. 创建编码器(编码或是字节流), 并 CharBuffer 中的数据进行编码
            charBuffer.flip();
            CharsetEncoder cer = cs.newEncoder();
            ByteBuffer byteBuffer = cer.encode(charBuffer);

            // 4. 创建解码器, 并解码
            CharsetDecoder cdr = cs.newDecoder();
            CharBuffer charBuffer2 = cdr.decode(byteBuffer);

            // 5. 输出解码后的
            log.info(charBuffer2.toString());
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }

    /** 打印Charset中有多少种字符集 */
    @Test
    public void testCharset() {

        SortedMap<String, Charset> map = Charset.availableCharsets();
        // 168
        System.out.println("Charset中有" + map.size() + "种字符集");
        for (Map.Entry<String, Charset> iterable_element : map.entrySet()) {
            System.out.println(iterable_element.getKey() + ":" + iterable_element.getValue());
        }
    }
}
