# Spring Boot with Docker and Kubernetes 

## Docker 

- Build Docker image: 
```
mvn clean package 
 ``` 
- Push image 
```
docker push kasunindrasiri/product-service-springboot 
```

- Run
```
docker run -d -p 8080:8080 kasunindrasiri/product-service-springboot

```

- Test
```
curl http://localhost:8080/hello 
```



## Kubernetes 

- Deploy 
```
kubectrl apply -f k8s 
```
- Test 

    Find the Node port for the K8s service 
    ```
    kubectl get svc
        spring-boot-service        NodePort       10.108.67.144   <none>        8080:31791/TCP   29s
        
    curl http://localhost:31791/hello
    ```


