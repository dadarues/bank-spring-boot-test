FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8082
COPY application.properties /application.properties
COPY prueba-java-spring-0.0.1.jar /prueba-java-spring-0.0.1.jar
ENTRYPOINT [ "java", "-jar", "prueba-java-spring-0.0.1.jar" ]