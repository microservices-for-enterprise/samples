
# Spring Boot - RESTful Service 

This sample demonstrate the RESTful service capabilities of Spring Boot. 

## Test Service 
You can test the RESTful service with the following HTTP requests. 

### Retrieve Order : HTTP GET  
``
curl http://localhost:8080/order/100
``


### Add Order : HTTP POST 

``` 
curl -v -X POST -d \
'{ "id": "100500", "name": "XYZ", "description": "Sample order."}' \
"http://localhost:8080/order" -H "Content-Type:application/json"
```

