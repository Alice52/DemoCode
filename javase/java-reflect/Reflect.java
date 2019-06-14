import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zack
 * @create 2019-06-14 11:48
 * @function Test the API of Reflect.
 */
public class Reflect {

    @Test
    public void testGetClass() {
        // 1.获取Class对象: 3方法
        Class<Person> clazz1 = Person.class;
        Class<Person> clazz2 = (Class<Person>) (new Person("123", 12)).getClass();
        System.out.println(clazz1);
        System.out.println(clazz2);
    }

    @Test
    public void testNewInstance() throws Exception {
        // 2.创建实例
        Class<Person> clazz1 = Person.class;
        Person Person = clazz1.newInstance();
        System.out.println(Person);
    }

    // 测试类加载器
    @Test
    public void testClassLoader() throws Exception {
        // 3.1 获取一个系统的类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        ClassLoader classLoader6 = this.getClass().getClassLoader();
        System.out.println(classLoader == classLoader6); //sun.misc.Launcher$AppClassLoader@456d3d51
        // 3.2 获取系统类加载器的父类: 扩展类加载器
        ClassLoader classLoader2 = classLoader.getParent();
        System.out.println(classLoader2); //sun.misc.Launcher$ExtClassLoader@6d4b473
        // 3.3 获取扩展类加载器的父类: 引导类加载器
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3); //获取不到,返回null

        // 3.4 测试当前类由哪个类加载器加载
        Class<Person> clazz = (Class<Person>) Class.forName("Reflect");
        ClassLoader classLoader4 = clazz.getClassLoader();
        System.out.println(classLoader4);  // sun.misc.Launcher$AppClassLoader@456d3d51: 和上一个系统类加载器一样,说明是由系统类加载器加载

        // 3.5 测试 JDK 中 String 类是由哪个类加载器加载
        ClassLoader classLoader5 = String.class.getClassLoader();
        System.out.println(classLoader5); // null,说明由引导类加载器加载

        // 3.6 关于类加载器的一个主要方法:
        // 读取当前工程下的.properties的输入流: this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        // InputStream inputStream=new FileInputStream("./src/jdbc.properties");
        // InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        // Properties properties = new Properties();
        // properties.load(inputStream);
        // System.out.println(properties.getProperty("root"));
    }

    @Test
    public void testMethods() throws Exception {
        Class<Person> clazz = Person.class;
        // 4.1 得到类中的方法: 包含父类方法, 但获取不了私有方法
        Method[] methods = clazz.getMethods();

        // 4.2 得到类中的方法: 包括私有方法, 但是不包含父类方法
        Method[] methods2 = clazz.getDeclaredMethods();

        // 4.3 获取指定的方法
        Method method = clazz.getDeclaredMethod("testReflect");
        System.out.println(method.getName());
        Method method2 = clazz.getDeclaredMethod("testReflect2", String.class, Integer.class);
        System.out.println(method2.getName());
        // 4.4 执行方法
        Person person = clazz.newInstance();
        method2.setAccessible(true); // 若方法是私有的要使其可访问
        method2.invoke(person, "123", 12);

        // 4.5 自己定义一个定义方法: invoke(obj,MethodName,Object...aegs)
        ReflectionUtils.invoke(person, "testReflect2", "132", 12); //把上面的步揍分装成函数
        // 4.6 自己定义一个定义方法: invoke(String className,String methodName, Object...args)
        ReflectionUtils.invoke(Person.class, "testReflect2", "132", 12);

        // 4.7 自己定义一个定义方法,使其父类私有方法也可以调用: invoke2(String className,String methodName, Object...args)
        Object object = ReflectionUtils.invoke("java.text.SimpleDateFormat", "format", new Date());
        System.out.println(object);            //18-5-31 下午6:24
    }

    @Test
    public void testFields() throws Exception {
        Class<?> clazz = Person.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Object obj = clazz.newInstance();  // 创建一个对象实例
        // 5.1 获取字段数组：
        Field[] fields = clazz.getDeclaredFields(); // all filed
        Field[] fields2 = clazz.getFields();  // public filed
        // 5.2 获取指定的field
        Field field = clazz.getDeclaredField("name");
        System.out.println(field.getName()); // age
        // 5.3 get private field
        Field field2 = ReflectionUtils.getField(clazz, "age");
        System.out.println(field2);
        field.setAccessible(true); //注意私有属性问题
        // 5.4 获取指定的field得值：
        Object name = field.get(obj);  //获取name的值
        System.out.println(name);
        // 5.5 为指定属性赋值：
        field.set(obj, "连顺");
        System.out.println(field.get(obj));
    }

    @Test
    public void testConstructor() throws Exception {
        Class<?> clazz = Person.class;
        // 1. Returns an array containing {@code Constructor} objects reflecting all the public constructors
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }

        // 2. Return specific constructor
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        // 3. Uses the constructor represented by this {@code Constructor} object to create
        Object obj = constructor.newInstance("张壮壮", 12);
        System.out.println(obj);
    }
}
