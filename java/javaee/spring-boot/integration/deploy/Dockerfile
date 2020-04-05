
#基础镜像
FROM openjdk:8
#创建/tmp目录并持久化到Docker数据文件夹，因为Spring Boot使用的内嵌Tomcat容器默认使用/tmp作为工作目录
VOLUME /tmp
#复制test-1.0-SNAPSHOT.jar到/opt/app下且重命名为app.jar
COPY target/test-1.0-SNAPSHOT.jar /opt/app/app.jar
#复制配置文件到jar包外，为了以后在docker中修改配置文件，不然每次修改配置都要重出镜像
COPY target/classes/application.properties /opt/app/application.properties
COPY start.sh /opt/app/start.sh
#说明容器开放的端口
EXPOSE 80
#指定docker容器时区
# CentOS
RUN echo "Asia/shanghai" > /etc/timezone;
#容器启动后执行的命令，运行项目且指定spring配置文件环境
# ENTRYPOINT java -jar /opt/app/app.jar --spring.profiles.active=production
#容器启动后执行的命令，运行项目且指定spring配置文件地址
# ENTRYPOINT java -jar /opt/app/app.jar --spring.config.location=/opt/app/application.properties
# 脚本启动
ENTRYPOINT sh /opt/app/start.sh
