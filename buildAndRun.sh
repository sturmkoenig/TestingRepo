#!/bin/sh
mvn clean package && docker build -t MySQLPerson/SQLConnectionTest .
docker rm -f SQLConnectionTest || true && docker run -d -p 8080:8080 -p 4848:4848 --name SQLConnectionTest MySQLPerson/SQLConnectionTest 
