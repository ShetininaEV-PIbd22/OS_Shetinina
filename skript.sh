#!/bin/bash
url="https://gitlab.com/romanov73/example-jpa/tree/master/"
git clone $url
cd /home/liza
cd ./example-jpa/
gradle build
docker build -t nextdocker1 -f for_postgres .
docker network create --driver bridge postgres-network
sudo docker cp /home/liza/example-jpa/build/libs/example-jpa-0.1.0-SNAPSHOT.jar nextdocker1:/var/
docker run --name nextdocker1 --network postgres-network -v pgdata:/var/lib/postgresql/9.3/main -p 5432:5432 -d nextdocker1
sudo docker exec -it nextdocker1 java /var/example-jpa-0.1.0-SNAPSHOT.jar
echo "OK"


