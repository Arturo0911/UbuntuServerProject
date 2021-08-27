#!/usr/bin/bash

# first at all check if docker is already installed
echo"[*] checking Docker version..."
docker --version

# after that, create the mysl instance
echo"[*] creating instance for mysql container"
docker run -d -p 2012:3306 --name mysql-spring-docker -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=UbuntuServerProject -e MYSQL_USER=root_arturo -e MYSQL_PASSWORD=LikeAStone mysql:latest


echo"[*] up the container"
docker run -t --name spring-docker-app --link mysql-spring-docker:mysql -p 8087:8080 spring-docker


