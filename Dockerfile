FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/home/app/target/DevOps-Project-1.0.0-SNAPSHOT.jar"]