minikube-start:
	minikube start


minikube-stop:
	minikube stop


delete-all:
	kubectl delete all --all

run-pods:
	kubectl create -f ./kube/mysql-pod.yml
	kubectl create -f ./kube/comment-pod.yml
	kubectl create -f ./kube/like-pod.yml
	kubectl create -f ./kube/user-pod.yml
	kubectl create -f ./kube/image-pod.yml
	kubectl create -f ./kube/clientui-pod.yml

run-services:
	kubectl create -f ./kube/mysql-service.yml
	kubectl create -f ./kube/comment-service.yml
	kubectl create -f ./kube/like-service.yml
	kubectl create -f ./kube/user-service.yml
	kubectl create -f ./kube/image-service.yml
	kubectl create -f ./kube/clientui-service.yml

docker-build:
	docker compose build

docker-up:
	docker compose up -d

docker-down:
	docker compose down

