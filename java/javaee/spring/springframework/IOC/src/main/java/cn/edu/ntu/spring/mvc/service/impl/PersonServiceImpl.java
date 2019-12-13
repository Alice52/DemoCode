package cn.edu.ntu.spring.mvc.service.impl;

import cn.edu.ntu.spring.mvc.repository.PersonRepository;
import cn.edu.ntu.spring.mvc.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author zack
 * @create 2019-10-27 22:38
 * @function
 */
@Service
public class PersonServiceImpl implements PersonService {

  private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

  @Autowired
  @Qualifier(value = "personRepositoryMybatisImpl")
  private PersonRepository personRepository;

  @Override
  public void handleRegister() {
    personRepository.addUser();
  }
}
