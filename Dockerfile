FROM ubuntu:latest AS build

RUN apt-get update

RUN apt-get install eclipse-temurin:17-jdk-alpine

COPY . .

RUN apt-get install maven -y

RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

COPY --from=build /target/Pet-0.0.1.jar pet.jar

ENTRYPOINT [ "java", "-jar", "pet.jar" ]

