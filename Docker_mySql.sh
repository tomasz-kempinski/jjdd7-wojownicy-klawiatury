#!/bin/bash
docker run -p 0.0.0.0:3308:3306 --name bookhub -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bookhubdb -d mysql