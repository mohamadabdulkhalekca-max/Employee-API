# Employee RESTful Web Service

A simple RESTful web service built with **Java Spring Boot** for managing employee information.

This project was created to practice building REST APIs with Spring Boot, handling HTTP requests, working with structured resources, and preparing an application for deployment in a cloud environment such as **HPE GreenLake**.

## Features

* Retrieve all employees
* Create new employees
* Update existing employees
* Delete employees
* Validate employee information
* Store employee data in PostgreSQL
* Dockerized application and database
* Swagger/OpenAPI documentation

## Employee Information

Each employee contains:

* `employeeId`
* `firstName`
* `lastName`
* `email`
* `title`

## REST API Endpoints

| Method | Endpoint                  | Description           |
| ------ | ------------------------- | --------------------- |
| GET    | `/employees`              | Get all employees     |
| POST   | `/employees`              | Create a new employee |
| PUT    | `/employees/{employeeId}` | Update an employee    |
| DELETE | `/employees/{employeeId}` | Delete an employee    |

### Example Employee

```json
{
  "firstName": "Mohamad",
  "lastName": "Abdul Khalek",
  "email": "Mohamadabdulkhalekca@gmail.com",
  "title": "Software Engineer"
}
```

## Project Architecture

The application follows a layered architecture:

```text
Client
   ↓
Controller
   ↓
DTO / Validation
   ↓
Service
   ↓
Repository
   ↓
JPA / Hibernate
   ↓
PostgreSQL
```

### Main Technologies

* **Java 21**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL**
* **Maven**
* **Docker**
* **Docker Compose**
* **Swagger / OpenAPI**

## Running the Application

### Using Maven

Make sure Java 21 is installed, then run:

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

Test the employee endpoint:

```bash
curl http://localhost:8080/employees
```

## Running with Docker

Build the application:

```bash
./mvnw clean package -DskipTests
```

Build the Docker image:

```bash
docker build -t employee-api .
```

Start the application and PostgreSQL:

```bash
docker compose up -d
```

Check the containers:

```bash
docker compose ps
```

Test the API:

```bash
curl http://localhost:8080/employees
```

Stop the containers:

```bash
docker compose down
```

## Database

The application uses PostgreSQL for persistent employee data.

When using Docker Compose, PostgreSQL runs in its own container and the Spring Boot application connects to it through the Docker network.

Database configuration is provided through environment variables rather than being hard-coded into the application.

## API Documentation

Swagger/OpenAPI is included in the project to make it easier to explore and test the API.

Once the application is running, open:

```text
http://localhost:8080/swagger-ui/index.html
```

## Deployment

The application is containerized with Docker to make deployment easier across different environments.

The target deployment environment for this project is **HPE GreenLake**, where the Dockerized Spring Boot application and PostgreSQL database can be deployed depending on the infrastructure provided.

## Project Goal

The goal of this project is to gain practical experience with:

* Java Spring Boot
* RESTful web services
* HTTP methods and API design
* PostgreSQL databases
* JPA and Hibernate
* Docker and containerization
* Cloud deployment concepts
* HPE GreenLake

This project provides a foundation for building larger enterprise web services using Java and Spring Boot.
