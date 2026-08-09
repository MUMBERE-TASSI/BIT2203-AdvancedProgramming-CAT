# BIT2203 – Advanced Programming CAT

## Take-Away CAT

**Student Name:** MUMBERE TASSI DIEUMERCI
**Registration Number:** YOUR_REGISTRATION_NUMBER
**Course:** BIT2203 – Advanced Programming
**Institution:** Jomo Kenyatta University of Agriculture and Technology (JKUAT)
**Assessment:** Take-Away CAT
**Submission Date:** 12 August 2026

**GitHub Repository:**
https://github.com/MUMBERE-TASSI/BIT2203-AdvancedProgramming-CAT

---

# 1. Project Overview

This repository contains my solutions for the **BIT2203 – Advanced Programming Take-Away CAT**.

The assessment demonstrates practical understanding and implementation of advanced Java programming concepts, including:

* Network programming
* TCP and UDP communication
* URL parsing
* JDBC database connectivity
* Java Servlets
* HTTP sessions
* Dependency Injection
* Spring IoC concepts
* Java RMI
* Servlet lifecycle
* MVC architecture

Each question is implemented separately and organized according to the individual assessment requirements.

The source code has been compiled, tested, documented, and pushed to a public GitHub repository as required by the assessment.

---

# 2. Objectives

The main objectives of this CAT are to demonstrate the ability to:

1. Understand the differences between TCP and UDP communication.
2. Explain practical applications of TCP and UDP.
3. Parse URLs using Java networking classes.
4. Develop database applications using JDBC.
5. Implement servlet-based web applications.
6. Manage user sessions using `HttpSession`.
7. Demonstrate Dependency Injection and the Spring IoC concept.
8. Implement remote communication using Java RMI.
9. Explain and demonstrate the servlet lifecycle.
10. Apply the Model-View-Controller (MVC) architecture.
11. Compile and test Java applications using appropriate tools.
12. Use Git and GitHub for source-code management and submission.

---

# 3. Technologies Used

The project uses the following technologies and tools:

| Technology       | Purpose                                    |
| ---------------- | ------------------------------------------ |
| Java             | Main programming language                  |
| Maven            | Project build and dependency management    |
| Java Servlet API | Web application and servlet development    |
| Apache Tomcat    | Servlet container                          |
| JDBC             | Database connectivity                      |
| Java RMI         | Remote method invocation                   |
| Spring Framework | Dependency Injection and IoC demonstration |
| Git              | Version control                            |
| GitHub           | Public source-code repository              |
| Linux/Ubuntu     | Development environment                    |

---

# 4. Project Structure

The project is organized according to the seven CAT questions.

```text
BIT2203-AdvancedProgramming-CAT/
│
├── src/
│   │
│   ├── q1/
│   │   └── URLParser.java
│   │
│   ├── q2/
│   │   └── JDBC source files
│   │
│   ├── q3/
│   │   └── ShoppingCartServlet.java
│   │
│   ├── q4/
│   │   ├── AppConfig.java
│   │   ├── DIApplication.java
│   │   ├── UserRepository.java
│   │   └── UserService.java
│   │
│   ├── q5/
│   │   ├── TemperatureClient.java
│   │   ├── TemperatureServer.java
│   │   ├── TemperatureService.java
│   │   └── TemperatureServiceImpl.java
│   │
│   ├── q6/
│   │   ├── LifecycleDemo.java
│   │   └── LifecycleServlet.java
│   │
│   └── q7/
│       ├── Book.java
│       ├── BookDAO.java
│       └── BookController.java
│
├── web/
│   └── bookList.jsp
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# 5. Question 1 – Networking and URL Parsing

## 5.1 TCP and UDP

TCP and UDP are transport-layer protocols used to provide communication between applications over a network.

### TCP

TCP, or Transmission Control Protocol, is a connection-oriented and reliable communication protocol.

TCP provides:

* Reliable data delivery
* Ordered delivery of packets
* Retransmission of lost packets
* Flow control
* Congestion control
* Connection establishment before communication

TCP is appropriate for applications where reliable and complete delivery of information is important.

Examples include:

* Web browsing
* Email
* File transfer
* Secure web communication

### UDP

UDP, or User Datagram Protocol, is a connectionless communication protocol.

Unlike TCP, UDP does not guarantee:

* Delivery of packets
* Packet ordering
* Retransmission of lost packets

However, UDP has lower communication overhead and is useful where speed and low latency are more important than guaranteed delivery.

Examples include:

* Live streaming
* Video conferencing
* Online gaming
* Voice communication
* DNS

### UDP Real-World Scenario

UDP is suitable for real-time communication such as video conferencing.

During a video conference, a small amount of packet loss is usually preferable to waiting for lost packets to be retransmitted. Retransmission can introduce delays and affect the real-time nature of the communication.

Therefore, UDP can provide faster communication with lower latency.

---

## 5.2 URL Parsing

The Java `URL` class from the `java.net` package is used to extract different components of a URL.

The URL used for the demonstration is:

```text
https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews
```

The URL contains the following components:

```text
Protocol: https
Host: api.techstore.com
Port: 8443
Path: /products/category/electronics
Query Parameters:
    sort = price
    limit = 20
Fragment: reviews
```

### Source Code

The URL parsing implementation is contained in:

```text
src/q1/URLParser.java
```

The program demonstrates how Java can be used to extract individual URL components using the `java.net.URL` class.

---

# 6. Question 2 – JDBC

Question 2 demonstrates the use of **Java Database Connectivity (JDBC)** to allow a Java application to communicate with a relational database.

JDBC provides a standard API for Java applications to:

* Establish database connections
* Execute SQL statements
* Retrieve database records
* Insert records
* Update records
* Delete records

The JDBC implementation is contained in:

```text
src/q2/
```

The implementation demonstrates the use of Java and JDBC for performing database-related operations.

JDBC provides a bridge between the Java application and the database through database drivers and SQL statements.

---

# 7. Question 3 – Shopping Cart Servlet

Question 3 implements a Java Servlet that manages a shopping cart using an HTTP session.

The main servlet is:

```text
src/q3/ShoppingCartServlet.java
```

The servlet is mapped using:

```java
@WebServlet("/shopping-cart")
```

---

## 7.1 HTTP Session

The shopping cart is stored inside the user's `HttpSession`.

The servlet obtains the session using:

```java
HttpSession session = request.getSession();
```

The cart is maintained inside the session so that items can remain available across multiple HTTP requests from the same user.

The cart attribute is identified using:

```java
private static final String CART_ATTRIBUTE = "cart";
```

---

## 7.2 GET Request

The `doGet()` method retrieves the current shopping cart and displays its contents.

When the cart is empty, the application displays:

```text
Shopping Cart

Your cart is empty.
```

When items have been added, the items are displayed to the user.

---

## 7.3 POST Request

The `doPost()` method receives an item submitted by the user.

For example:

```text
Java Programming Book
```

The item is then added to the shopping cart stored in the user's session.

---

## 7.4 Deployment

The servlet application can be packaged as a WAR file and deployed using Apache Tomcat.

The Shopping Cart servlet can be accessed using:

```text
http://localhost:8080/advanced-programming-cat-1.0-SNAPSHOT/shopping-cart
```

The application provides a simple demonstration of session management using Java Servlets.

---

# 8. Question 4 – Dependency Injection

Question 4 demonstrates **Dependency Injection (DI)** and the **Spring IoC Container**.

The implementation contains:

```text
src/q4/
├── AppConfig.java
├── DIApplication.java
├── UserRepository.java
└── UserService.java
```

---

## 8.1 UserRepository

`UserRepository` is responsible for providing user information.

It represents the dependency required by the service layer.

---

## 8.2 UserService

`UserService` uses `UserRepository` to perform user-related operations.

Instead of creating the repository dependency directly inside the service, the dependency is provided by the Spring IoC container.

This demonstrates Dependency Injection.

---

## 8.3 AppConfig

`AppConfig` provides the Spring configuration required to create and manage application components.

The configuration allows Spring to manage the objects used by the application.

---

## 8.4 DIApplication

`DIApplication` is the main application used to demonstrate that the dependency has been successfully injected.

The application produced:

```text
Dependency Injection successful.
Retrieved user: User-101
```

This confirms that the required dependency was successfully provided to the service.

---

# 9. Question 5 – Java RMI Temperature Converter

Question 5 demonstrates **Java Remote Method Invocation (RMI)**.

RMI allows a Java application to invoke methods on an object running in another Java Virtual Machine.

The implementation contains:

```text
src/q5/
├── TemperatureClient.java
├── TemperatureServer.java
├── TemperatureService.java
└── TemperatureServiceImpl.java
```

---

## 9.1 Remote Interface

The remote service provides two temperature conversion methods:

```java
double celsiusToFahrenheit(double celsius)
```

and:

```java
double fahrenheitToCelsius(double fahrenheit)
```

The methods use:

```java
throws RemoteException
```

because communication with a remote object may produce communication-related exceptions.

---

## 9.2 Temperature Conversion

The Celsius-to-Fahrenheit formula is:

```text
°F = (°C × 9/5) + 32
```

The Fahrenheit-to-Celsius formula is:

```text
°C = (°F − 32) × 5/9
```

For example, converting 25°C to Fahrenheit:

```text
°F = (25 × 9/5) + 32
°F = 45 + 32
°F = 77
```

Therefore:

```text
25°C = 77°F
```

---

## 9.3 Testing Result

The RMI client was tested using:

```bash
java -cp out q5.TemperatureClient
```

The resulting output was:

```text
Temperature Conversion:
25.0°C = 77.0°F
77.0°F = 25.0°C
```

This confirms that the temperature conversion service works correctly.

---

# 10. Question 6 – Servlet Lifecycle

Question 6 demonstrates the lifecycle of a Java Servlet.

The implementation contains:

```text
src/q6/
├── LifecycleDemo.java
└── LifecycleServlet.java
```

The major stages of the servlet lifecycle are:

```text
Servlet Loading
       ↓
Initialization
       ↓
Request Processing
       ↓
Destruction
```

---

## 10.1 Servlet Loading

The web container loads the servlet class when it is required by the application.

---

## 10.2 Servlet Initialization

The container creates the servlet instance and calls:

```java
init()
```

The `init()` method is normally executed once during the servlet's lifecycle.

It can be used to perform initialization tasks such as loading configuration or preparing resources.

---

## 10.3 Request Processing

When a client sends a request, the servlet container invokes:

```java
service()
```

The request is then processed according to its HTTP method.

For example:

```java
doGet()
```

can process GET requests, while:

```java
doPost()
```

can process POST requests.

---

## 10.4 Servlet Destruction

When the servlet is removed from service or the application is stopped, the container calls:

```java
destroy()
```

This allows the servlet to release resources before it is removed.

---

## 10.5 Demonstration Output

The lifecycle demonstration produced output describing the following stages:

```text
=== Servlet Container Lifecycle Demonstration ===

1. Servlet Loading
   The servlet container loads the servlet class.

2. Servlet Initialization
   The container calls init() once.

3. Request Processing
   The container calls service() for each client request.

4. Servlet Destruction
   The container calls destroy() before removing the servlet.

=== Container Responsibilities ===
• Loading and instantiating servlets
• Managing the servlet lifecycle
• Receiving HTTP requests
• Providing request and response objects
• Managing servlet sessions
• Destroying servlets when they are no longer needed
```

---

# 11. Question 7 – MVC Library System

Question 7 demonstrates the **Model-View-Controller (MVC)** architecture using a simple library system.

The architecture separates the application into:

```text
Model
View
Controller
```

This separation improves organization, maintainability, and scalability.

---

## 11.1 Model

The model represents the application's data.

The `Book` class represents a book and contains information such as:

```text
ID
Title
Author
```

Source:

```text
src/q7/Book.java
```

---

## 11.2 Data Access Object

The `BookDAO` class is responsible for accessing and managing book data.

Source:

```text
src/q7/BookDAO.java
```

The DAO separates data-access operations from the controller and presentation layers.

---

## 11.3 Controller

The `BookController` handles incoming requests and coordinates communication between the DAO/model and the view.

Source:

```text
src/q7/BookController.java
```

The controller retrieves the required book information and passes it to the view.

---

## 11.4 View

The presentation layer is implemented using JSP.

Source:

```text
web/bookList.jsp
```

The JSP is responsible for displaying the list of books to the user.

---

## 11.5 MVC Request Flow

The general request flow is:

```text
User / Browser
      |
      | GET /books
      v
BookController
      |
      | getAllBooks()
      v
BookDAO
      |
      | List<Book>
      v
BookController
      |
      | setAttribute()
      | forward()
      v
bookList.jsp
      |
      | HTML response
      v
User / Browser
```

The MVC design separates:

* Data
* Business/request logic
* Presentation

This makes the application easier to maintain and modify.

---

# 12. Build and Compilation

Maven is used to build and manage the project.

To clean and compile the project:

```bash
mvn clean compile
```

To create the deployable package:

```bash
mvn clean package
```

The project is expected to generate a WAR file under the `target` directory.

For example:

```text
target/advanced-programming-cat-1.0-SNAPSHOT.war
```

---

# 13. Running Question 4

Question 4 can be executed using Maven:

```bash
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java \
-Dexec.mainClass="q4.DIApplication"
```

Expected output:

```text
Dependency Injection successful.
Retrieved user: User-101
```

---

# 14. Running Question 5

The Question 5 classes can be compiled using:

```bash
javac -d out src/q5/TemperatureService.java src/q5/TemperatureServiceImpl.java
```

The client can then be executed using:

```bash
java -cp out q5.TemperatureClient
```

Expected output:

```text
Temperature Conversion:
25.0°C = 77.0°F
77.0°F = 25.0°C
```

---

# 15. Running Question 6

The Question 6 classes can be compiled using:

```bash
javac -d out src/q6/LifecycleServlet.java src/q6/LifecycleDemo.java
```

The demonstration can then be executed using:

```bash
java -cp out q6.LifecycleDemo
```

The program displays the major stages of the servlet lifecycle and the responsibilities of the servlet container.

---

# 16. Running the Web Application

The web application can be packaged using:

```bash
mvn clean package
```

The resulting WAR file can then be deployed to Apache Tomcat.

After deployment, the Shopping Cart servlet can be accessed using:

```text
http://localhost:8080/advanced-programming-cat-1.0-SNAPSHOT/shopping-cart
```

---

# 17. Testing Summary

The implemented questions were tested during development.

| Question | Component                          | Status                   |
| -------- | ---------------------------------- | ------------------------ |
| Q1       | URL Parser and Networking Concepts | Successful               |
| Q2       | JDBC Programs                      | Implemented              |
| Q3       | Shopping Cart Servlet              | Successfully implemented |
| Q4       | Dependency Injection               | Successful               |
| Q5       | RMI Temperature Converter          | Successful               |
| Q6       | Servlet Lifecycle Demonstration    | Successful               |
| Q7       | MVC Library System                 | Successfully compiled    |

---

# 18. Git and GitHub

Git was used to manage the project source code and maintain the development history.

The public GitHub repository is:

```text
https://github.com/MUMBERE-TASSI/BIT2203-AdvancedProgramming-CAT
```

The repository contains the Java source code, project configuration, documentation, and supporting web files required for the assessment.

Git was used to:

* Track changes
* Organize development work
* Create commits
* Maintain project history
* Push the final implementation to GitHub

The final repository was checked using:

```bash
git status
```

A clean working tree indicates that all intended changes have been committed.

---

# 19. Version Control and .gitignore

A `.gitignore` file is included in the project to prevent unnecessary generated files from being committed to GitHub.

Examples of files and directories that should not be committed include:

```text
out/
*.class
target/
```

This keeps the repository focused on source code, configuration, and documentation while allowing the project to be compiled again when needed.

---

# 20. Reproducibility

The project is organized so that the source code can be obtained from GitHub and compiled using the documented commands.

A user can clone the repository using:

```bash
git clone https://github.com/MUMBERE-TASSI/BIT2203-AdvancedProgramming-CAT.git
```

Then enter the project directory:

```bash
cd BIT2203-AdvancedProgramming-CAT
```

The Maven project can be compiled using:

```bash
mvn clean compile
```

The deployable package can be generated using:

```bash
mvn clean package
```

---

# 21. Conclusion

This project demonstrates the practical application of advanced Java programming concepts covered in **BIT2203 – Advanced Programming**.

The seven questions cover important areas including:

* Computer networking
* TCP and UDP
* URL parsing
* JDBC
* Java Servlets
* HTTP sessions
* Dependency Injection
* Spring IoC
* Java RMI
* Servlet lifecycle
* MVC architecture

Each question has been organized separately within the project repository.

The source code has been compiled and tested using Java and Maven, with web-based components designed for deployment using Apache Tomcat.

The project has also been managed using Git and submitted through a public GitHub repository as required by the assessment.

This repository therefore provides both the implementation and documentation of the work completed for the BIT2203 Take-Away CAT.

---

# 22. Student and Submission Information

**Student Name:** MUMBERE TASSI DIEUMERCI

**Registration Number:** YOUR_REGISTRATION_NUMBER

**Course:** BIT2203 – Advanced Programming

**Assessment:** Take-Away CAT

**Institution:** Jomo Kenyatta University of Agriculture and Technology (JKUAT)

**Submission Date:** 12 August 2026

**GitHub Repository:**

https://github.com/MUMBERE-TASSI/BIT2203-AdvancedProgramming-CAT

---

## Final Checklist

Before submission, confirm the following:

* [ ] Registration number has been added.
* [ ] `README.md` is present.
* [ ] Questions 1–7 are present.
* [ ] Java source files are present.
* [ ] `pom.xml` is present.
* [ ] `.gitignore` is present.
* [ ] `target/` is not unnecessarily committed.
* [ ] `.class` files are not committed.
* [ ] The repository is public.
* [ ] The GitHub repository link is correct.
* [ ] The project compiles successfully.
* [ ] Final changes have been committed.
* [ ] Final changes have been pushed to GitHub.
* [ ] `git status` shows a clean working tree.
