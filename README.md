#  Learning Management System (LMS)

A full-stack **Learning Management System** built using **Java, JSP, Servlets, JDBC, MySQL**, and **Docker**.  
This project demonstrates role-based access control, course management, student enrollment, and admin operations.

---

##  Features

###  Student
- Register & Login
- View available courses
- Enroll in courses
- View enrolled courses
- View profile (read-only by default)
- Deactivate own account (soft delete)

###  Admin
- Login as Admin
- Add & view courses
- Manage users (activate / deactivate)
- Change user roles (Admin / Student)

---

##  Tech Stack

- **Backend:** Java, JSP, Servlets
- **Database:** MySQL 8
- **Build Tool:** Maven
- **Server:** Apache Tomcat 9
- **Containerization:** Docker & Docker Compose
- **Frontend:** JSP, Bootstrap 5

---

##  Project Structure
```
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
```

---

##  Prerequisites

Install the following:

- Java 17 or 21
- Maven
- MySQL 8
- Docker & Docker Compose (for Docker run)
- Git

---

#  MySQL Database Setup

###  Create Database
```sql
CREATE DATABASE lms;
USE lms;
```

###  Create Application User
```sql
CREATE USER 'lmsuser'@'localhost' IDENTIFIED BY 'lms123';
GRANT ALL PRIVILEGES ON lms.* TO 'lmsuser'@'localhost';
FLUSH PRIVILEGES;
```

###  Create users Table
```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN','STUDENT') NOT NULL,
    full_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
###  Create courses Table
```sql
CREATE TABLE courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);
```
###  Create enrollments Table
```sql
CREATE TABLE enrollments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    course_id INT,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE RESTRICT,
    CONSTRAINT fk_course FOREIGN KEY (course_id)
        REFERENCES courses(id)
        ON DELETE RESTRICT
);
```
###  Insert Default Admin User
```sql
INSERT INTO users
(username, password, role, full_name, email, status)
VALUES
(
 'admin@lms.com',
 '$2a$10$QhWKholKA4Q62bBNHU..aO3D07C2w/b3cgoUClaPcPb5sl4VVLBXK',
 'ADMIN',
 'System Admin',
 'admin@lms.com',
 'ACTIVE'
);
```
##  Admin Login
```ymal
Username / Email: admin@lms.com
Password: admin123
```
##  Database Configuration in Code
```java
DBUtil.java
private static final String URL =
    System.getenv("DB_URL") != null ?
    System.getenv("DB_URL") :
    "jdbc:mysql://localhost:3306/lms";

private static final String USER =
    System.getenv("DB_USER") != null ?
    System.getenv("DB_USER") : "lmsuser";

private static final String PASSWORD =
    System.getenv("DB_PASS") != null ?
    System.getenv("DB_PASS") : "lms123";
```
## Run Project Locally
### Clone the repository
```bash
git clone https://github.com/<your-username>/lms-project.git
cd lms-project
```
### Build the project
```bash
mvn clean package
```
### Deploy WAR to Tomcat
- Copy target/lms.war
- Paste into tomcat/webapps/
- Start Tomcat

### Access the application
```bash
http://localhost:8080/lms/
```

## Run Project Using Docker
### Build WAR
```bash
mvn clean package
copy target\lms.war .
```
### Start containers
```bash
docker-compose up --build
```
### Access the application
```bash
http://localhost:8080/
```

### Docker automatically:
- Starts MySQL
- Creates database & user
- Deploys LMS on Tomcat

## Resume Highlights
- Developed a full-stack LMS using Java, JSP, Servlets, JDBC, and MySQL
- Implemented role-based authentication for Admin and Student
- Containerized the application using Docker and Docker Compose
- Designed normalized database schema with foreign key constraints

## Author

```
Babloo Kumar
Computer Science Engineering Student
Skilled in Java, JDBC, JSP, Servlets, MySQL, Docker
```
