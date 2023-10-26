FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /app

WORKDIR /app

COPY target/Pet-0.0.1.jar /app/Pet-0.0.1.jar

CMD ["java", "-jar", "/app/Pet-0.0.1.jar"]