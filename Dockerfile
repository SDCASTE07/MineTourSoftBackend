FROM openjdk:11
FROM maven:3.2.5-jdk-11-slim
WORKDIR /app
COPY . /app
# RUN mvn clean package -DskipTests
VOLUME /tmp
ADD /target/MineTourSoft-0.0.1-SNAPSHOT.jar /myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]