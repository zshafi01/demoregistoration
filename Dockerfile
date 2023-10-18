#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package

#
# Package stage
#
FROM openjdk
COPY --from=build /target/demoRegistoration-0.0.1-SNAPSHOT.jar demoRegistoration.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demoRegistoration.jar"]