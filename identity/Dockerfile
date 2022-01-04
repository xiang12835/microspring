FROM java:8-jdk-alpine

COPY ./target/identity-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "identity-1.0.0-SNAPSHOT.jar"]