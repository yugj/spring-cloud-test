FROM 10.124.129.188/common/oracle-jdk:1.8
VOLUME /tmp
ADD rest-server-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]