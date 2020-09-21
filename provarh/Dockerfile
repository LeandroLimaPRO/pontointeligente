FROM openjdk:11
FROM maven:3.6.3-openjdk-11
WORKDIR /app
COPY . /app
ADD ./target/spring-pulse.jar .
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8086:8086
ENTRYPOINT ["java", "-jar", "spring-pulse.jar"]