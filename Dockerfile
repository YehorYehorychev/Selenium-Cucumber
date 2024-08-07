FROM bellsoft/liberica-openjdk-alpine:17.0.10

RUN apk update && \
    apk add --no-cache curl jq maven

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

COPY target/Selenium-Cucumber-1.0-SNAPSHOT.jar /app/Selenium-Cucumber.jar

ENTRYPOINT ["java", "-jar", "/app/Selenium-Cucumber.jar"]
