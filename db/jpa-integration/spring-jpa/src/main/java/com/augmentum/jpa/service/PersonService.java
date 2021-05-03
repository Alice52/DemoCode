package com.augmentum.jpa.service;

import com.augmentum.jpa.dao.PersonDao;
import com.augmentum.jpa.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zack
 * @create 2019-08-10 19:54
 * @function
 */
@Service
public class PersonService {

    @Autowired private PersonDao personDao;

    @Transactional
    public void savePersons(Person p1, Person p2) {
        personDao.save(p1);
        // int i = 10 / 0;
        personDao.save(p2);
    }
}
