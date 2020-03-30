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

    - is standalone consumer

3.  eureka

    - cloud-consumer-order80

      - **consumer**: is cluster consumer, register to `cloud-eureka-server700, cloud-eureka-server7002`
      - and service provide is `cloud-provider-payment8001, cloud-provider-payment8002`

    - cloud-eureka-server7001
    - cloud-eureka-server7002

      - **register center**: accept service provider and consumer registration
      - self protect and heartbeat setting
      - and comment has standalone config
      - **it is broken server**

    - cloud-provider-payment8001
    - cloud-provider-payment8002

      - **service provider**, register to `cloud-eureka-server700, cloud-eureka-server7002`
      - config actuator info, such as IP, service name, heartbeat etcs

4.  zookeeper

    - cloud-provider-payment8004
    - cloud-consumer-order84-zookeeper
      - integration with zookeeper
      - zookeeper version should be consistent with jar

5.  consul

    - cloud-consumer-order86-consul
    - cloud-provider-payment8006-consul
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

---

## Issues

1. Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project springbootdemo: Fatal error compiling

   - may JDK version
   - **may dependency version: ** my issue is cause by lombok version error
