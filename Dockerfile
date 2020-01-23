FROM openjdk:8-jdk-alpine
RUN  addgroup -S appuser && \
    adduser -S -g appuser appuser
USER appuser
WORKDIR /app
COPY target/my-first-microservice-lab-2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]