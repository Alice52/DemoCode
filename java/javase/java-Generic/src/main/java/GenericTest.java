import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-06-14 17:58
 */
public class GenericTest {

  private static final Logger LOG = LoggerFactory.getLogger(GenericTest.class);

  @Test
  public void testGeneric() {
    Generic<Person> pers = new Generic<>();
    Person person = pers.get();
    person.setAge(20);
    System.out.println(person.getAge());

    // public <E> E getProperty(E e)
    int age1 = pers.test(12);
    Person s = pers.test(new Person("zack", 18));
    LOG.info(age1 + "   " + s);
  }
}
