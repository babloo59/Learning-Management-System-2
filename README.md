# 📘 Learning Management System (LMS)

A full-stack **Learning Management System** built using **Java, JSP, Servlets, JDBC, MySQL**, and **Docker**.  
This project demonstrates role-based access control, course management, student enrollment, and admin operations.

---

## 🚀 Features

### 👨‍🎓 Student
- Register & Login
- View available courses
- Enroll in courses
- View enrolled courses
- View profile (read-only by default)
- Deactivate own account (soft delete)

### 👨‍💼 Admin
- Login as Admin
- Add & view courses
- Manage users (activate / deactivate)
- Change user roles (Admin / Student)

---

## 🛠️ Tech Stack

- **Backend:** Java, JSP, Servlets
- **Database:** MySQL 8
- **Build Tool:** Maven
- **Server:** Apache Tomcat 9
- **Containerization:** Docker & Docker Compose
- **Frontend:** JSP, Bootstrap 5

---

## 📂 Project Structure

LMS/
├── src/main/java
│ └── com.bk.lms
│ ├── controller
│ ├── dao
│ ├── model
│ ├── service
│ └── util
│
├── src/main/webapp
│ ├── *.jsp
│ └── WEB-INF
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md

---

## ⚙️ Prerequisites

Install the following:

- Java 17 or 21
- Maven
- MySQL 8
- Docker & Docker Compose (for Docker run)
- Git

---

# 🗄️ MySQL Database Setup (FULL – COPY & RUN)

### 1️⃣ Login to MySQL

```bash
mysql -u root -p
```

or on Ubuntu:
