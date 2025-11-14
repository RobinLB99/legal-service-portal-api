FROM maven:3.9-eclipse-temurin-21-noble AS build

WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn

RUN mvn dependency:go-offline

COPY src ./src

CMD ["mvn", "spring-boot:run"]
