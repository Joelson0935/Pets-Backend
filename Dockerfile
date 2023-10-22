FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/Pet-0.0.1.jar  /app/Pet.jar

ENTRYPOINT ["java", "-jar", "/Pet.jar"]