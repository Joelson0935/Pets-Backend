FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /application

WORKDIR /application

COPY target/Pet-0.0.1.jar /application/pet.jar

CMD [ "java", "-jar", "/application/pet.jar" ]