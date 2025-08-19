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
