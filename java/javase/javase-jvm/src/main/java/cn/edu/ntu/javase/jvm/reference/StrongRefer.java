package cn.edu.ntu.javase.jvm.reference;

/**
 * @author zack <br>
 * @create 2021-03-02 15:01 <br>
 * @project javase <br>
 */
public class StrongRefer {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();

        // null
        System.out.println(o1);
        // java.lang.Object@12a3a380, 此时堆中的空间也没有被回收
        System.out.println(o2);
    }
}
