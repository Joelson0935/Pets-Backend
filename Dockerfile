FROM eclipse-temurin:17-jdk-alpine

RUN mkdir /application

WORKDIR /application

ADD . /application

RUN mvn clean package

COPY target/*.jar /application/pet.jar

EXPOSE 8080

CMD [ "java", "-jar", "/application/pet.jar" ]