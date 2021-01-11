package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;

import java.util.List;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class IntegrateWithCollection {

  public static int countAge(List<? extends Person> persons) {

    return persons.stream().map(x -> x.getAge()).reduce(0, Integer::sum);
  }

  public static int countAge1(List<Person> persons) {

    return persons.stream().map(x -> x.getAge()).reduce(0, Integer::sum);
  }
}
