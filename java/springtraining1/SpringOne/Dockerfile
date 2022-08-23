FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD target/spring-boot-docker-app.jar spring-boot-docker-app.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker-app.jar"]