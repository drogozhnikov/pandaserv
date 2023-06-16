FROM openjdk:11 as build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pandaserv.jar
ENTRYPOINT ["java","-jar","pandaserv.jar"]
