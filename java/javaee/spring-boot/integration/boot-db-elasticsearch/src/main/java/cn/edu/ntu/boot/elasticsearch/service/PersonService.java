package cn.edu.ntu.boot.elasticsearch.service;

import cn.edu.ntu.boot.elasticsearch.model.Person;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author zack <br>
 * @create 2020-10-28 21:45 <br>
 * @project springboot <br>
 */
public interface PersonService {

    /**
     * create Index
     *
     * @author fxbin
     * @param index elasticsearch index name
     */
    void createIndex(String index);

    /**
     * delete Index
     *
     * @author fxbin
     * @param index elasticsearch index name
     */
    void deleteIndex(String index);

    /**
     * insert document source
     *
     * @author fxbin
     * @param index elasticsearch index name
     * @param list data source
     */
    void insert(String index, List<Person> list);

    /**
     * update document source
     *
     * @author fxbin
     * @param index elasticsearch index name
     * @param list data source
     */
    void update(String index, List<Person> list);

    /**
     * delete document source
     *
     * @author fxbin
     * @param person delete data source and allow null object
     */
    void delete(String index, @Nullable Person person);

    /**
     * search all doc records
     *
     * @author fxbin
     * @param index elasticsearch index name
     * @return person list
     */
    List<Person> searchList(String index);
}
