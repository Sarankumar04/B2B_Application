FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/*.jar order-service.jar

EXPOSE 9092

ENTRYPOINT ["java","-jar","order-service.jar"]