FROM anapsix/alpine-java:8_server-jre_unlimited
VOLUME /tmp
ADD target/boot-encrypt-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE  8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -DJASYPT_ENCRYPTOR_PASSWORD=ZACK_KEY -jar /app.jar"]
