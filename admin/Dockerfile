FROM java:8-jdk-alpine

COPY ./target/admin-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "admin-1.0.0-SNAPSHOT.jar"]