import org.junit.Test;

/**
 * @author zack
 * @create 2019-06-14 17:58
 * @function
 */
public class TestGeneric {

    @Test
    public void testGeneric() {
        Generic<Person> pers = new Generic<>();
        Person person = pers.get();
        person.setAge(20);
        System.out.println(person.getAge());

        int age1 = pers.test(12); // public <E> E getProperty(E e)
        String s = pers.test("12");
        System.out.println(age1 +"   "+s);
    }
}
