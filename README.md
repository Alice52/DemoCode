# demo code

![Build Status](https://travis-ci.com/Alice52/tutorials-sample.svg?branch=feat-test-travis)

This repository is exist for other note [repository](https://github.com/Alice52/java-ocean), and it is all sample.

## content

## wiki

- Click [here](https://github.com/Alice52/DemoCode/wiki) to get the wiki of repository, and you can get more detail about sample.

## question

### mq-activemq

// TODO

#### This connection should be singleton, and all lifecycle just has one connection. And can reference Rabbitmq[esb].

- solution 1:
  - get connection use the session, which is created by connection. In this case, please reference mybatis.
  ```
  conn =  sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
  ```
- solution 2:
  - use applicationContext to store all singleton var.

#### how to get clientID

#### maven project

- sub module how to use parent project dependency
  - solution: `in sub module tag <relativePath>`
  ```xml
  <parent>
      <artifactId>activemq</artifactId>
      <groupId>com.augmentum.mq</groupId>
      <version>1.0-SNAPSHOT</version>
      <relativePath>../pom.xml</relativePath>
  </parent>
  ```
- sub module how to use parent project config

#### exception

1. Cause: Broker: localhost - Client: subscriber02-topic already connected from tcp://183.213.100.153:20137
   - solution: persistence subscribers
