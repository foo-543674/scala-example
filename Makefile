setup:
	docker network create scala-example

prepare_env:
	docker-compose -f ./localexec/docker-compose.yaml up -d

destruct_env:
	docker-compose -f ./localexec/docker-compose.yaml down

uninstall:
	docker network rm scala-example