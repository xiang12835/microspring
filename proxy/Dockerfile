FROM java:8-jdk-alpine

COPY ./target/proxy-1.0.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "proxy-1.0.0-SNAPSHOT.jar"]