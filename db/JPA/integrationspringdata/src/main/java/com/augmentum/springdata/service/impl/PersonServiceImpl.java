package com.augmentum.springdata.service.impl;

import com.augmentum.springdata.entities.Person;
import com.augmentum.springdata.repository.PersonRepository;
import com.augmentum.springdata.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zack
 * @create 2019-08-10 22:57
 * @function
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void savePersons(List<Person> persons) {
        personRepository.saveAll(persons);
    }

    @Transactional
    public void updatePersonEmail(String email, Integer id){
        personRepository.updatePersonEmail(id, email);
    }
}
