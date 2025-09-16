FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/*.jar user-service-docker.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","user-service-docker.jar"]