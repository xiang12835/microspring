FROM java:8-jdk-alpine

COPY ./target/gateway-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "gateway-1.0.0-SNAPSHOT.jar"]