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

  void savePersons(List<Person> persons);

  void updatePersonEmail(String email, Integer id);
}
