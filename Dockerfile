FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
ENV JAR_TARGET "canban-api-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=docker ./build/libs/${JAR_TARGET}"]