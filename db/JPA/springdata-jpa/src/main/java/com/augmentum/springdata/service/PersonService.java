package com.augmentum.springdata.service;

import com.augmentum.springdata.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zack
 * @create 2019-08-10 22:56
 * @function
 */
@Service
public interface PersonService {

  /**
   * save person in batch
   *
   * @param persons
   */
  void savePersons(List<Person> persons);

  /**
   * update person info
   *
   * @param email
   * @param id
   */
  void updatePersonEmail(String email, Integer id);
}
