docker tag frontend silteo/frontend
docker push silteo/frontend
kubectl expose deployment frontend-deployment --type=LoadBalancer --name=frontend-service
kubectl apply -f ./deployment.yml