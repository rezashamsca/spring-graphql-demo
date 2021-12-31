# spring-graphql-demo application

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.alpha.rtecsoft.springgraphqldemo.SpringGraphqlDemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/) like so:

```shell
./gradlew bootRun 
```

## Deploying the application using docker container

In order to create docker container for the app, please use the following command

```shell
docker build . --build-arg JAR_FILE=build/libs/\*.jar --tag rtecsoft/spring-graphql-demo:v0.0.1-SNAPSHOT
```

In order to run the app, please use the following command:

```shell
docker run --name spring-graphql-demo-http -p 80:8080 rtecsoft/spring-graphql-demo:v0.0.1-SNAPSHOT  
```

