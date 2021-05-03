package com.augmentum.springdata.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author zack
 * @create 2019-08-11 0:30
 * @function
 */
public class PersonRepositoryImpl implements PersonDao {

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepositoryImpl.class);

    @PersistenceContext private EntityManager entityManager;

    public void test() {
        LOG.error(
                "PersonRepositoryImpl can do not implements PersonRepository, just implements PersonDao. And PersonRepository can use the method in PersonDao.");
    }
}
