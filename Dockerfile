FROM openjdk:11 as build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} PandaservApplication.jar
ENTRYPOINT ["java","-jar","PandaservApplication.jar"]
