```
docker-compose -f  ./build.yml build
docker tag frontend silteo/frontend
docker push silteo/frontend
kubectl expose deployment frontend-deployment --type=LoadBalancer --name=frontend-service
kubectl apply -f ./deployment.yml
```

 - https://nginx.org/en/docs/
 - https://github.com/GoogleCloudPlatform/postgresql-docker/blob/master/9/README.md
 - https://medium.com/@thms.hmm/docker-for-mac-with-kubernetes-enable-k8s-dashboard-62fe036b7480