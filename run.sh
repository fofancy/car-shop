#!/bin/sh

( cd backend && ./gradlew clean assemble && sudo docker build -t carshop-backend .)
( cd frontend && npm install && webpack && sudo docker build -t carshop-frontend .)

( cd devops && sudo docker-compose -f docker-compose.yml up)
