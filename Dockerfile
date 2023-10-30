FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean pacakage

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/Pet-0.0.1.jar Pet-0.0.1.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar","Pet-0.0.1.jar" ]