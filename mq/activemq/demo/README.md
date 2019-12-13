## Question

// TODO

### This connection should be singleton, and all lifecycle just has one connection. And can reference Rabbitmq[esb].

- solution 1:
  - get connection use the session, which is created by connection. In this case, please reference mybatis.
  ```
  conn =  sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
  ```
- solution 2:
  - use applicationContext to store all singleton var.

### how to get clientID

### maven project

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


### delay send is error
```log
<broker xmlns="http://activemq.apache.org/schema/core" brokerName="localhost" dataDirectory="${activemq.data}" schedulerSupport="true">
error: Attribute "schedulerSupport" was already specified for element "broker".
```
