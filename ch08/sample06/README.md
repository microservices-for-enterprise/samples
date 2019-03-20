# Metaparticle with Spring boot. 


## Build
```
mvn clean spring-boot:run 
```

## Run
Deploy ingress for Kubernetes: 
```
kubectl apply -f ingress.yaml 
```

Test your application: 
```
curl metaparticle.demo.io/metaparticle
``` 