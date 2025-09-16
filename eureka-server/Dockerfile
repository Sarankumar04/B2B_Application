FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/*.jar eureka-sever.jar

EXPOSE 5768

ENTRYPOINT ["java","-jar","eureka-sever.jar"]