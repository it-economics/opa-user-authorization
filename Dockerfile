FROM openjdk:17.0.2-jdk-slim

LABEL author="it-economics GmbH"

EXPOSE 8081

RUN mkdir /app

COPY build/libs/*.jar /app/service.jar

ENTRYPOINT ["java", "-jar", "/app/service.jar"]