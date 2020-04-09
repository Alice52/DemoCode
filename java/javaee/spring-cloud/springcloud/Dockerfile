FROM java:8
ENV MYPATH /opt/cloud
WORKDIR $MYPATH
VOLUME /tmp
CMD ["echo",  "$PWD"]
ADD cloud-provider-payment8001/**/*.jar $MYPATH
EXPOSE  8010
ENTRYPOINT ["java", "-jar","$MYPATH/*.jar"]