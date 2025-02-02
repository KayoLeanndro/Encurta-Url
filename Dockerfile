FROM openjdk:17
COPY ./target/url_shortner-0.0.1-SNAPSHOT.jar /app.jar
COPY src/main/resources/templates /app/resources/templates

ENTRYPOINT ["java", "-jar", "/app.jar"]
