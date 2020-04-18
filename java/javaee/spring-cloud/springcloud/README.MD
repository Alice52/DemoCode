## maven build

1. JDK Version: 11

   - add JVM args: `--illegal-access=deny`

2. Maven Project SDK Point Out

   ```xml
   <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <maven.compiler.source>11</maven.compiler.source>
       <maven.compiler.target>11</maven.compiler.target>
   </properties>
   ```

3. Choose Project Language Level and Build Compile JDK

4. Choose this Project SDK.

5. Plugin:

   - Lombok Plugin
   - Google Java Format
   - Alibaba Java Coding Guidelines

## Module introduce

1.  cloud-api-commons

    - common models and Utils

2.  cloud-consumer-order81

    - is standalone consumer, can call payment service by RestTemplate success.

3.  eureka

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002
        - **register center**: accept service provider and consumer registration
        - self protect and heartbeat setting
        - and comment has standalone config
        - **it is broken server**
        - cluster guideline is contain others eureka server besides itself

    - service provider:

      - cloud-provider-payment8001
      - cloud-provider-payment8002
        - **service provider**, register to `cloud-eureka-server700, cloud-eureka-server7002`
        - config actuator info, such as IP, service name, heartbeat etcs

    - service consumer:

      - cloud-consumer-order80-eureka-ribbon
        - **consumer**: is cluster consumer, register to `cloud-eureka-server700, cloud-eureka-server7002`
        - and service provide is `cloud-provider-payment8001, cloud-provider-payment8002`

4.  ribbon

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider:

      - cloud-provider-payment8001
        - provider fallback service
      - cloud-provider-payment8002
        - nature service and not provider fallback service

    - consumer:

      - cloud-consumer-order80-customlb
        - this module is implement ribbon algorithms: CAS + Spin Lock
      - cloud-consumer-order80-eureka-ribbon

5.  zookeeper

    - service discovery: zookeeper installed in server

    - provider:

      - cloud-provider-payment8004-zookeeper

    - consumer:

      - cloud-consumer-order84-zookeeper
        - integration with zookeeper
        - zookeeper version should be consistent with jar

6.  consul

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider:

      - cloud-provider-payment8006-consul

    - consumer:

      - cloud-consumer-order86-consul

    - notice: Heartbeat detection and health check are two different method
      - When we configure `spring.cloud.consul.discovery.heartbeat.enabled` = true,
        spring cloud uses the heartbeat check push mechanism
        to periodically report its survival status to the consul server.
        If there is no report within the time limit, the server considers it abnormal.
      - When `heartbeat.enabled` = false, the health check mechanism is enabled.
        We can configure the health check interval with the following parameters.
      ```properties
      spring.cloud.consul.discovery.health-check-interval=1s
      ```
    - https://blog.csdn.net/swordcenter/article/details/99286423

7.  feign

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider:

      - cloud-provider-payment8001
      - cloud-provider-payment8002

    - consumer:

      - cloud-consumer-order80-feign

8.  hystrix

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider:

      - cloud-provider-payment8010-hystrix-fallback: contain fallback handle
      - cloud-provider-payment8011-hystrix-circuit-breaker: contain circuit breaker handler

    - consumer:

      - cloud-consumer-dashboard-hystrix9001
        - it monitor provider service
      - cloud-consumer-order80-hystrix-feign
        - it demo timeout issue
      - cloud-consumer-order80-feign-hystrix
        - TODO: how to resolve timeout issue if is more than 1s?
        - this is decoupling, and need enable feign's hystrix in yml

    - monitor:
      - cloud-consumer-dashboard-hystrix9001

9.  gateway

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider:

      - cloud-provider-payment8001

    - gateway
      - cloud-gateway-gateway9001

10. config

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - config center

      - cloud-config-center3344: contain dynamic refresh

    - config client
      - cloud-config-client3355: donot contain dynamic refresh, should call api to notice this service
      - cloud-config-client3355: contain dynamic refresh, can refresh by call api to notice config center

11. stream

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider

      - cloud-stream-rabbitmq-provider8801

    - consumer
      - cloud-stream-rabbitmq-consumer8811
      - cloud-stream-rabbitmq-consumer8812

12. sleuth

    - service discovery: eureka

      - cloud-eureka-server7001
      - cloud-eureka-server7002

    - provider

      - cloud-stream-rabbitmq-provider8801

    - consumer
      - cloud-consumer-order80-eureka-ribbon

13. nacos register center

    - service discovery: nacos in docker and can be cluster
    - provider
      - cloud-alibaba-provider-payment9001
      - cloud-alibaba-provider-payment9002
    - consumer
      - cloud-alibaba-consumer-order91

14. nacos config center

    - service discovery: nacos in docker and can be cluster
    - config center: nacos in docker and can be cluster

      - cloud-config-center3344: contain dynamic refresh

    - config client
      - cloud-alibaba-config-client3377

15. sentinel

    - server: run in docker ot local
    - snetinel
      -cloud-alibaba-sentinel8401

16. seata

---

## Issues

1. Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project springbootdemo: Fatal error compiling

   - may JDK version
   - **may dependency version: ** my issue is cause by lombok version error

2. [expensive]hystrix: if provider and consumer all do service fallback:

   - project module: `cloud-consumer-order80-hystrix-feign`
   - provider fallback timeout: 3s, but the method execute cost 5s, so it will trigger this fallback in 3s
   - consumer fallback timeout: 4s, so what happened?

     - phenomenon is consumer triggered itself fallback when 1s, why??

   - **`the question is cause by ribbon and hystrix timeout issue`**
   - this is because ribbon default timeout is 1s, and hystrix default timeout is also 1s, so if change the args with 1s, everything is fine
   - if the args is more than 1s, should do follow change

     - consumer client should add the below code: **`because hystrix and ribbon work together, it will determine by that shortest`**

     ```yml
     ribbon:
       # the time should more than provider service
       ReadTimeout: 3500
       connectionTimeout: 3500
     ```

   - if consumer hystrix timeout set 20s, and ribbon timeout set 40s; provider hystrix time set 30s, and method execute costs 50s, so consumer will trigge itself fallback when 20s
   - if consumer hystrix timeout set 40s, and ribbon timeout set 20s; provider hystrix time set 30s, and method execute costs 50s, so consumer will trigge itself fallback when 20s
