FROM maven:3.8.4-eclipse-temurin-17 AS build

COPY src /app/src
COPY pom.xml /app


WORKDIR /app
RUN mvn clean install

FROM eclipse-temurin:17-jre-alpine

COPY --from=build /app/target/crm-connector-0.0.1-SNAPSHOT.jar /app/app.jar



WORKDIR /app

EXPOSE 3131

CMD ["java", "-jar", "app.jar"]
