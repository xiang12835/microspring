FROM java:8-jdk-alpine

COPY ./target/scheduler-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "scheduler-1.0.0-SNAPSHOT.jar"]