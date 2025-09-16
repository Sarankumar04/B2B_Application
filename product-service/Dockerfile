FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/*.jar product-service.jar

EXPOSE 9091

ENTRYPOINT ["java","-jar","product-service.jar"]