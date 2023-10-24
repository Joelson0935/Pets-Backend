FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /application

WORKDIR /application

COPY target/*.jar /application/pet.jar

CMD [ "java", "-jar", "/application/pet.jar" ]