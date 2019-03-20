
Vert.x HTTP Invoker 

Build 

```  mvn clean package ```

Run 

Start backend service: 

``` java -jar target/vertx-restful-service-3.5.3-fat.jar ``` 

Start invoker service: 

``` java -jar target/vertx-service-invoker-3.6.2-fat.jar ``` 

Test

``` curl http://localhost:9090/invoker ``` 
