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

1. cloud-api-commons

   - common models and Utils

2. cloud-eureka-server7001

   - **register center**: accept service provider and consumer registeration
   - self protect and heartbeat setting
   - and comment has stastandalone config

3. cloud-eureka-server7002: same as `2`
4. cloud-consumer-order80

   - **consumer**: is cluster consumer, register to `cloud-eureka-server700, cloud-eureka-server7002`
   - and service provide is `cloud-provider-payment8001, cloud-provider-payment8002`

5. cloud-consumer-order81

   - is stastandalone consumer

6. cloud-provider-payment8001

   - **service provider**, register to `cloud-eureka-server700, cloud-eureka-server7002`
   - config actuator info, such as IP, service name, heartbeat etcs

7. cloud-provider-payment8002: same as `6`

---

## Issues

1. Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project springbootdemo: Fatal error compiling

   - may JDK version
   - **may dependency version: ** my issue is cause by lombok version error
