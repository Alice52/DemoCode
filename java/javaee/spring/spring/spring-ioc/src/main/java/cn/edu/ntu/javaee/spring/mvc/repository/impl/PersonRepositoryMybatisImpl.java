package cn.edu.ntu.javaee.spring.mvc.repository.impl;

import cn.edu.ntu.javaee.spring.mvc.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author zack
 * @create 2019-10-27 22:38
 * @function
 */
@Repository
public class PersonRepositoryMybatisImpl implements PersonRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepository.class);

    @Override
    public void addUser() {
        LOG.info("MVC processor is success by use {}.", this.getClass());
    }
}
