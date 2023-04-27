FROM maven:3.8.1-jdk-8-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package
CMD ["mvn", "clean", "test"]