FROM java:8-jdk-alpine

COPY ./target/office-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "office-1.0.0-SNAPSHOT.jar"]