# task-manager-backend

[![License](https://img.shields.io/badge/license-MIT-green)](LICENSE)

## Overview
The **Task Manager Backend** is a Spring Boot REST API that provides CRUD operations for managing tasks. It is designed to serve as the backend for mobile (Android) and web (React) clients. Features include:

- User authentication (JWT-based)
- Task creation, update, deletion, and retrieval
- PostgreSQL database integration
- Ready for Docker deployment
- Unit testing with JUnit & Mockito

This project is part of a full-stack Task Manager application.

---

## 🛠 Tech Stack
- **Backend Framework:** Spring Boot 3.x  
- **Database:** PostgreSQL  
- **Security:** JWT (JSON Web Tokens)  
- **ORM:** Spring Data JPA  
- **Build Tool:** Maven  
- **Testing:** JUnit, Mockito  
- **Deployment:** Docker, AWS (planned)

---

## ⚡ Features
- Create, Read, Update, Delete (CRUD) tasks  
- JWT-secured endpoints for authenticated access  
- API documentation via Swagger  
- Ready for integration with Android and React frontends  

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven
- PostgreSQL
- (Optional) Docker

### Setup

1. **Clone the repository**
```bash
git clone https://github.com/janepounds/task-manager-backend.git
cd task-manager-backend

2. Configure Database
Update src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. Run the application
mvn spring-boot:run

API Endpoints
| Method | Endpoint          | Description             |
| ------ | ----------------- | ----------------------- |
| GET    | `/api/tasks`      | Get all tasks           |
| POST   | `/api/tasks`      | Create a new task       |
| PUT    | `/api/tasks/{id}` | Update an existing task |
| DELETE | `/api/tasks/{id}` | Delete a task           |

Example POST Request
{
  "title": "Learn Spring Boot",
  "description": "Understand basics",
  "completed": false
}

🔗 Related Projects

Android Frontend: Task Manager Android

React Web Frontend: Task Manager Web

🛠 Future Improvements

Add user registration & authentication (JWT)

Implement microservices (Auth + Tasks)

Deploy to AWS with CI/CD
