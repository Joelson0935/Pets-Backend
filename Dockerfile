FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /app

WORKDIR /app

COPY target/*.jar /app/pet.jar

CMD ["java", "-jar", "/app/pet.jar"]