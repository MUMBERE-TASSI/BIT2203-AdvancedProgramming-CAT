# BIT2203 Advanced Programming CAT

## Student Information

**Name:** MUMBERE TASSI DIEUMERCI

**Registration Number:** SCT221-0594/2024

**Course:** BIT 2203 – Advanced Programming

**Assessment:** Take-Away CAT

**Submission Deadline:** 12 August 2026

## Repository Description

This repository contains the Java programs, configuration files,
and supporting resources developed for the BIT 2203 Advanced
Programming Take-Away CAT.

All programs have been organized according to the questions in
the assessment. Each Java source file is properly commented and
can be compiled and executed using the instructions provided
below.

## Programs

### Question 1

TCP and UDP concepts and URL parsing using Java's URL class.

**Source file:**

`src/q1/URLParser.java`

### Question 2

JDBC database connectivity, PreparedStatement authentication,
database table creation, data insertion, and data retrieval.

**Source files:**

`src/q2/StudentLogin.java`

`src/q2/UniversityDatabase.java`

### Question 3

Java Servlets, JSP, and HTTP session management using HttpSession.

### Question 4

Microservices concepts and Spring Dependency Injection using
constructor injection.

### Question 5

Java Remote Method Invocation (RMI) using a temperature
conversion service.

### Question 6

Java Servlet container responsibilities and Servlet lifecycle.

### Question 7

Model-View-Controller (MVC) implementation for a Library
Management System.

## Technologies Used

* Java
* JDBC
* MySQL
* Java Servlets
* JSP
* Spring Framework
* Java RMI
* Git
* GitHub

## Project Structure

```text
BIT2203-AdvancedProgramming-CAT/
│
├── README.md
├── .gitignore
│
├── src/
│   ├── q1/
│   │   └── URLParser.java
│   │
│   ├── q2/
│   │   ├── StudentLogin.java
│   │   └── UniversityDatabase.java
│   │
│   ├── q3/
│   ├── q4/
│   ├── q5/
│   ├── q6/
│   └── q7/
│
└── web/
    └── bookList.jsp
```

## Dependencies

### Question 1

Question 1 uses standard Java libraries and does not require any
external JAR files.

### Question 2 – JDBC

Question 2 requires **MySQL Connector/J** for JDBC connectivity.

**Dependency:**

* MySQL Connector/J 9.4.0
* JAR file: `mysql-connector-j-9.4.0.jar`

The JDBC driver is not committed to the repository. It should be
downloaded separately from the official MySQL website.

### Database Configuration

Question 2 uses the following local MySQL database:

```text
Database: university_db
Host: localhost
Port: 3306
Username: admin
Password: secure123
```

## Question 2 Database Setup

Create the database using MySQL:

```sql
CREATE DATABASE university_db;
```

Create the database user:

```sql
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'secure123';
```

Grant the required privileges:

```sql
GRANT ALL PRIVILEGES ON university_db.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
```

## Compilation and Execution

### Question 1

Compile:

```bash
mkdir -p out
javac -d out src/q1/URLParser.java
```

Run:

```bash
java -cp out q1.URLParser
```

### Question 2

Download MySQL Connector/J and place the JAR in the appropriate
local library directory.

Compile `StudentLogin.java`:

```bash
javac -cp "lib/mysql-connector-j-9.4.0/mysql-connector-j-9.4.0.jar" \
-d out src/q2/StudentLogin.java
```

Run:

```bash
java -cp "out:lib/mysql-connector-j-9.4.0/mysql-connector-j-9.4.0.jar" \
q2.StudentLogin
```

Compile `UniversityDatabase.java`:

```bash
javac -cp "lib/mysql-connector-j-9.4.0/mysql-connector-j-9.4.0.jar" \
-d out src/q2/UniversityDatabase.java
```

Run:

```bash
java -cp "out:lib/mysql-connector-j-9.4.0/mysql-connector-j-9.4.0.jar" \
q2.UniversityDatabase
```

## Question 2 Test Results

### Student Authentication

The `StudentLogin` program was successfully connected to the
`university_db` database and authenticated the sample student.

Expected output:

```text
Login successful.
Student: BIT/001/2026
```

### Course Database

The `UniversityDatabase` program successfully created the
`courses` table, inserted three sample courses, and retrieved
courses belonging to the Computer Science department.

Expected output includes:

```text
Connected to university_db successfully.
Courses table created successfully.
Three sample courses inserted.

Courses in the Computer Science department:
Course ID: 101
Course Name: Advanced Programming
Credits: 3
Department: Computer Science
-------------------------
Course ID: 102
Course Name: Database Systems
Credits: 3
Department: Computer Science
-------------------------
```

## Future Dependencies

Additional dependencies required for Servlets, JSP, Spring, and
other programs will be documented here as the corresponding
questions are implemented.

## Author

**Name:** MUMBERE TASSI DIEUMERCI

**Registration Number:** SCT221-0594/2024
### Question 3 – Servlets

Question 3 uses the Java Servlet API.

Dependency:
- Servlet API 4.0.1
- JAR: servlet-api-4.0.1.jar

The Servlet API is required to compile ShoppingCartServlet.java.
A Servlet container such as Apache Tomcat is required to deploy
and execute the servlet as a web application.
