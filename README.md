
# User service

---
[![Build Status](https://img.shields.io/badge/development-30-blue)](https://github.com/bademba/user-service/tree/master)

This is a CRUD application for user service

---
## Endpoints

| Operation      | Description | Full Endpoint |
| ----------- | ----------- | ----------- |
| GET /userservice/users    | get list of all users | http://localhost:9192/v1/userservice/users|
| POST /userservice/users   | add a new user | http://localhost:9192/v1/userservice/users |
| GET /userservice/users/{id} | get a user by id | http://localhost:9192/v1/userservice/users/{id} |
| PUT /userservice/users/{id} | update a user | http://localhost:9192/v1/userservice/users/{id} |
| DELETE /userservice/users/{id} | delete a user | http://localhost:9192/v1/userservice/users/{id} |
## Logging
Logs are created in the /logs folder