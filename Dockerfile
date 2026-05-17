FROM gradle:8.10.2-jdk21 AS builder

WORKDIR /app

COPY build.gradle settings.gradle gradlew gradlew.bat ./
COPY gradle ./gradle
COPY src ./src

RUN chmod +x ./gradlew && ./gradlew bootJar --no-daemon -x test


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S tripton && adduser -S tripton -G tripton

COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker
ENV SERVER_PORT=8080
ENV JAVA_OPTS=""

EXPOSE 8080

USER tripton

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
