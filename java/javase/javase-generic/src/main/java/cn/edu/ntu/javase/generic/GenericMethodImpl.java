package cn.edu.ntu.javase.generic;

import cn.edu.ntu.javase.common.model.Person;
import cn.hutool.json.JSONObject;

import java.util.Objects;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class GenericMethodImpl extends BaseGenericMethod<Person> {

    @Override
    public int hash() {
        Person instance = this.createInstance(Person.class);
        return Objects.hash(instance);
    }
}
