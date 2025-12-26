FROM maven:3.9.11-eclipse-temurin-11-alpine

RUN apk add --no-cache curl jq dos2unix

WORKDIR /home/seleniumbddtestframework

COPY src src
COPY pom.xml .
COPY testng.xml .
COPY runner.sh runner.sh

RUN dos2unix runner.sh
RUN mvn clean compile

ENTRYPOINT ["sh", "runner.sh"]
