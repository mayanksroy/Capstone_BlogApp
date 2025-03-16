FROM openjdk:17-jdk-slim

LABEL maintainer="mayanksingh200241@gmail.com"

WORKDIR /app

COPY target/BlogApplication-0.0.1-SNAPSHOT.jar /app/blogapp.jar

ENTRYPOINT ["java", "-jar", "blogapp.jar"]
