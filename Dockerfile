FROM openjdk:17-slim
WORKDIR /app
COPY target/efile-manager-system-backend-0.0.1-SNAPSHOT.jar /app/my-app-1.0.jar
ENTRYPOINT ["java", "-jar", "my-app-1.0.jar"]