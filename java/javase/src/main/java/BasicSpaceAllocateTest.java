/**
 * @author zack
 * @create 2019-06-10 11:29
 * @function
 */
public class BasicSpaceAllocateTest {
    public static void main(String[] args) {
        Integer integer = new Integer(2);
        Integer integer2 = new Integer(2);

        System.out.println(integer == integer2);                // false
        System.out.println(integer.equals(integer2));           // true
        Integer integer3 = 2;                                   // 这里自动装箱
        Integer integer4 = 2;
        System.out.println(integer3 == integer4);               // 这里自动拆箱 // true
        System.out.println(integer3.equals(integer4));          //true
        System.out.println(integer == integer3);                // false

        String String = "123";
        String String2 = "123";
        System.out.println(String == String2);                  //true
        System.out.println(String.equals(String2));             //true
    }
}
