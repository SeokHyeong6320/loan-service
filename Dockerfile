# Dockerfile

FROM openjdk:21
RUN mkdir -p deploy
WORKDIR /deploy
COPY ./build/libs/loan-service-0.0.1-SNAPSHOT.jar loan-service.jar
ENTRYPOINT ["java", "-jar", "/deploy/loan-service.jar"]