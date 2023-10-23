FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /app

WORKDIR /app

COPY target/Pet-0.0.1.jar  /app/pet.jar

ENTRYPOINT ["java", "-jar", "pet.jar"]