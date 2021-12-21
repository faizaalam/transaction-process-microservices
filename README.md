# transaction-process-microservices

## Requirements

For building and running the application you need:

- JDK 1.8
- Gradle 7.1
- Spring boot 2.5.6

## Run applications:
1) First run the Eureka Server. Spring Eureka dashboard: http://localhost:8761/

```shell
cd eureka-config
./gradlew bootrun
```

2) Transaction Controller Service. Endpoints can be acecessed at http://localhost:9000/swagger-ui/#/
### Exposed endpoints: 
1) /apis
2) /apis/do-transactions

```shell
cd transaction
./gradlew bootrun
```

3)  Transaction Microservice: Runs at port 9100

```shell
cd transaction-microservice
./gradlew bootrun
```
 

