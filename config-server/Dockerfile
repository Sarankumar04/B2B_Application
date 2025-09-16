FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/*.jar  config-server.jar

EXPOSE 4444

ENTRYPOINT ["java","-jar","config-server.jar"]