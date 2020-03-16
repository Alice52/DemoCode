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



---

## Maven

1. Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project springbootdemo: Fatal error compiling
    - may JDK version
    - may dependency version
   
