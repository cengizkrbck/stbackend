# stbackend
Backend Softtech Case Study 

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Building & Running the application locally

```shell
mvn clean install 
``` 

```shell
mvn spring-boot:run
```

## Working with API

Browse to  localhost:8090/swagger-ui.html

_survey-controller_ endpoint includes methods to create or list questions.

_results-controller_ endpoint includes methods to submit or populate subject user's answers.


## Future works 
Unable to find time to implement this tasks. (it is not an excuse, just fyi) 

- enrich swagger documentation
- support follow-up question
- tests
- rest-api validations
- simple angular frontend to play with backend API