FROM eclipse-temurin:17-jdk-focal

ADD target/*.jar /app/rest-api-springboot-redis.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "rest-api-springboot-redis.jar"]