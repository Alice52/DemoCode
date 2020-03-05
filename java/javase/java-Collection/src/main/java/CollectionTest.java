import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;


public class CollectionTest {

    /**
     * 功能：取集合Collection中最小值(按需求找)<br/>
     * 1.这里测试的是List：但是对于所有Collection都适应<br/>
     * Object min(Collection)               //自然排序：对象要实现Comparable接口<br/>
     * Object min(Collection，Comparator)   //定制排序，姓名按升序排列<br/>
     */
    @Test
    public void testMin() {

        // 1.List中的min(): 定制排序，姓名按升序排列
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("d", 20));
        persons.add(new Person("b", 15));
        persons.add(new Person("c", 60));
        persons.add(new Person("a", 28));
        persons.add(new Person("e", 12));
        persons.add(new Person("f", 42));

        Person person = Collections.min(persons, Comparator.comparingInt(Person::getAge));
        Person person8 = Collections.min(persons, Comparator.comparing(Person::getName));

        System.out.println(person);
        System.out.println(person8);
    }

    /**
     * 功能：将 Person 类型的集合转换为 Person 的数组
     */
    @Test
    public void testToArray() {
        Collection<Person> persons = new ArrayList<>();
        persons.add(new Person("d", 20));
        persons.add(new Person("b", 15));
        persons.add(new Person("c", 60));
        persons.add(new Person("a", 28));
        persons.add(new Person("e", 12));
        persons.add(new Person("f", 42));
        //将Person类型的集合转换为Person的数组
        Person[] pers = persons.toArray(new Person[0]);
        System.out.println(pers.length);
    }

  @Test
  public void testCollectionRetainAll() {
      Collection a = new ArrayList(Arrays.asList("a", "b", "c", "d"));
      Collection b = new ArrayList(Arrays.asList("ab", "bc", "e", "f"));
      b.add("g");
      // a will become intersection
      a.retainAll(b);

      a.stream().forEach(System.out::println);
      System.out.println();
      b.stream().forEach(System.out::println);

      if(a.size()>0){
          System.out.println("have intersection");
      }else{
          System.out.println("have no intersection");
      }
  }

  @Test
  public void testCollectionAddAll() {
      Collection a = new ArrayList(Arrays.asList("a", "b", "c", "d"));
      Collection b = new ArrayList(Arrays.asList("ab", "bc", "e", "f"));

      b.add("g");
      // a will become intersection
      a.addAll(b);

      a.stream().forEach(System.out::println);
      System.out.println();
      b.stream().forEach(System.out::println);
  }
}
