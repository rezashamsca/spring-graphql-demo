FROM openjdk:11
ARG JAR_FILE_NAME=spring-graphql-demo-0.0.2.jar
ARG JAR_FILE=build/libs/spring-graphql-demo-0.0.2.jar
COPY ${JAR_FILE} ${JAR_FILE_NAME}
ENTRYPOINT ["java","-jar","/spring-graphql-demo-0.0.2.jar"]