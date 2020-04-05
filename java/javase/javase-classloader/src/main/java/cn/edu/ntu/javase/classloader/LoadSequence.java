package cn.edu.ntu.javase.classloader;

/**
 * 1. 初始化父类静态属性 <br>
 * 2. 执行父类静态代码块 <br>
 * 3. 初始化子类静态属性 <br>
 * 4. 执行子类静态代码块<br>
 * <br>
 * 5. 初始化父类实例变量<br>
 * 6. 执行父类动态代码块<br>
 * 7. 执行父类构造方法<br>
 * <br>
 * 8. 初始化子类实例变量<br>
 * 9. 执行子类动态代码块<br>
 * 10.执行子类构造方法<br>
 *
 * @author zack <br>
 * @create 2020-04-04 22:06 <br>
 */
public final class LoadSequence {}
