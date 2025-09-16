FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/*.jar gateway.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","gateway.jar"]