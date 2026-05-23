# Smart Contact Manager

A full-stack web application built using Java, Spring Boot, Thymeleaf, Hibernate, MySQL, and Spring Security that allows users to securely manage their contacts online.

---

# 🚀 Features

* User Registration & Login
* Spring Security Authentication
* Role-Based Authorization
* BCrypt Password Encryption
* Add New Contacts
* Update Existing Contacts
* Delete Contacts
* View All Contacts
* Upload Contact Profile Images
* User Dashboard
* Form Validation
* Session-Based Authentication
* Responsive UI using Bootstrap

---

# 🛠️ Tech Stack

## Backend

* Java 17
* Spring Boot 3
* Spring MVC
* Spring Security
* Spring Data JPA
* Hibernate

## Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap
* JavaScript

## Database

* MySQL

## Build Tool

* Maven

---

# 📂 Project Structure

```bash
src/main/java/com/smart
│
├── config          # Security configuration
├── controller      # Controllers
├── dao             # Repository layer
├── entities        # Entity classes
├── helper          # Helper classes
│
src/main/resources
│
├── static          # CSS, JS, Images
├── templates       # Thymeleaf templates
├── application.properties
```

---

# 🔐 Spring Security Configuration

This project uses Spring Security for authentication and authorization.

## Security Features

* Custom Login Page
* Role-Based Access Control
* BCrypt Password Encoding
* Custom UserDetailsService
* DAO Authentication Provider
* Protected User Routes

## Roles

| Role  | Access      |
| ----- | ----------- |
| USER  | `/user/**`  |
| ADMIN | `/admin/**` |

---

# 🧩 Main Modules

## 👤 Authentication Module

* Signup
* Login
* Logout
* Secure Authentication

## 📇 Contact Management Module

* Add Contact
* View Contact
* Edit Contact
* Delete Contact
* Upload Contact Images

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/mahendra90999/SmartContactManager.git
```

---

## 2️⃣ Open Project

Open the project in:

* IntelliJ IDEA
* Spring Tool Suite (STS)
* Eclipse

---

## 3️⃣ Configure MySQL Database

Create database:

```sql
CREATE DATABASE smartcontact;
```

---

## 4️⃣ Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartcontact
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## 5️⃣ Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```bash
http://localhost:8080
```

---

# 📚 Concepts Used

* MVC Architecture
* Dependency Injection
* ORM with Hibernate
* JPA Repository
* Spring Security
* Authentication & Authorization
* File Upload Handling
* Form Validation
* Session Management

---

# 📦 Maven Dependencies Used

* spring-boot-starter-web
* spring-boot-starter-thymeleaf
* spring-boot-starter-data-jpa
* spring-boot-starter-security
* spring-boot-starter-validation
* mysql-connector-j

---

# 🎯 Future Improvements

* REST API Integration
* JWT Authentication
* Email Verification
* Docker Deployment
* Pagination & Search
* Cloud Image Storage
* Microservices Migration

---

# 🧠 Learning Outcomes

This project helped in understanding:

* Spring Boot Architecture
* Spring Security Workflow
* Hibernate & JPA
* Full Stack Development
* Authentication & Authorization
* CRUD Operations
* Database Integration

---

# 👨‍💻 Author

## Mahendra Patil

* GitHub: [https://github.com/mahendra90999](https://github.com/mahendra90999)

---

# ⭐ Support

If you like this project, give it a ⭐ on GitHub.
