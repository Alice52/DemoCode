package cn.edu.ntu.javase.syntax;

/**
 * @author zack <br>
 * @create 2020-04-04 16:37 <br>
 */
public final class ConvertData {

    /**
     * convert byte[] to String. <br>
     * hutool: StrUtil.str(new byte[]{1}, Charset.defaultCharset());
     *
     * @param bytes
     * @return String
     */
    public static String convert(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * convert String to byte[]. <br>
     * hutool: StrUtil.bytes(str);
     *
     * @param str
     * @return byte[]
     */
    public static byte[] convert(String str) {
        return str.getBytes();
    }
}
