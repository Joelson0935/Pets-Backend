FROM eclipse-temurin:17-jdk-alpine

COPY target/*.jar /app/pet.jar

WORKDIR /app

CMD ["java", "-jar", "pet.jar"]