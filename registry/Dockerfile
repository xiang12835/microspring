FROM java:8-jdk-alpine

COPY ./target/registry-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "registry-1.0.0-SNAPSHOT.jar"]