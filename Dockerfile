FROM eclipse-temurin:17-jdk-alpine

ADD target/Pet-*.jar Pet.jar

ENTRYPOINT [ "java", "-jar", "/Pet.jar" ]