package cn.edu.ntu.javase.jvm;

import cn.edu.ntu.javase.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GcRoots 的对象
 *
 * <pre>
 *    1. 虚拟机栈的栈帧中的局部变量区, 也叫做局部变量表
 *    2. 方法区中的类静态属性引用的对象
 *    3. 方法区中常量引用的对象
 *    4. 本地方法栈中 N(Native 方法)引用的对象
 * </pre>
 *
 * @author zack <br>
 * @create 2021-03-02 13:01 <br>
 * @project javase <br>
 */
@Slf4j
public class GcRoots {

    // 2.方法区中的类静态属性引用的对象: 静态属性所指向的对象
    private static Person person = new Person();
    // 3.方法区中常量引用的对象: 常量池中所指向的对象
    private static final Person PERSON_FINAL = new Person();


    public static void main(String[] args) {
        // 1. 局部变量表: 比如方法内的局部变量和方法参数
        GcRoots temp = new GcRoots();
        // 不能回收 temp 对象
        System.gc();
    }


}
