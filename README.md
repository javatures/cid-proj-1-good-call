# Project 1: ghuD On The Web

## Mehrab's Notes
A Java 8 backend web API and ES6+ HTML/JS web interface with a PostgreSQL database. Submit a README.md with a proposal that matches as many requirements as manageable below. You may use the example proposal below for reference, or as your project itself.

### Tools & APIs
- [] Agile User Stories
- [] Java SE 8
- [] Gradle
- [] JDBC
- [] PostgreSQL
- [] JavaEE Servlet
- [] HTML/JS/CSS
- [] AJAX/Fetch
- [] JUnit
- [] log4j or similar
- [] Jest or similar JS testing framework
- [] Optional:
    - [] Docker, Docker-Compose
    - [] React
    - [] Bootstrap
    - [] Remote hosting (AWS EC2/RDS)
    - [] Jenkins CI automation
    - [] Mockito

### Architecture
- [] Anemic/DDD OR n-tier package & class structure
- [] Design Patterns:
    - [] Dependency Injection
    - [] Data Access Object
    - [] Business Delegate
    - [] Model-View-Controller
    - [] Front Controller
- [] SQL Normalization (3rd form)
- [] PL/pgSQL
- [] Optional:
    - [] Single Page Application

### Functionality
- [] CRUD - Create, Read, Update, Delete
- [] Web App dashboard interface
- [] Asynchronous interface updates
  - : update data using Promises
- [] Login - Authentication & Authorization
- [] Database persistance
- [] Session management
  - : login, logout, timeout

### Presentation
- [] Prepare a demonstration of functionality requirements through a browser
- [] Prepare visual aides (slides) introducing the project requirements and features

## Example: Expense Reimbursement System
A web application for managing reimbursement ticket submissions and approvals between employees and their managers.

### User stories
- An Employee...
    - [] can login
    - [] can view the Employee Homepage
    - [] can logout
    - [] can submit a reimbursement request
    - [] can upload an image of his/her receipt as part of the reimbursement request
    - [] can view their pending reimbursement requests
    - [] can view their resolved reimbursement requests
    - [] can view their information
    - [] can update their information
    - [] receives an email when one of their reimbursement requests is resolved (optional)

- A Manager...
    - [] can login
    - [] can view the Manager Homepage
    - [] can logout
    - [] can approve/deny pending reimbursement requests
    - [] can view all pending requests from all employees
    - [] can view images of the receipts from reimbursement requests
    - [] can view all resolved requests from all employees and see which manager resolved it
    - [] can view all Employees
    - [] can view reimbursement requests from a single Employee

`end Mehrab's notes`
* * *

## User Stories

- [ ] As a ghuD Person...
  - [ ] I can login to my ghuD so that 
  - [ ] I can view my Headspace so that
  - [ ] I can logout of my ghuD so that

## Tech Stack

### JavaSerlvet

Servlet:
Java class that generates **static webpages** with **dynamic data**

Performed tasks:
- takes incoming request
- processes request
- generates response
- sends response to user

HttpServlet example:
- takes HTTP request
- processes headers and contet
- writes HTML, CSS and JS into an HTTP response
- Sends response to user's web browser

Servlet container:
Component of an **application server** that interacts with Java servlets
- manages execution of servlets and Jakarta Server Pages (JSP) pages for Java apps
  - JSPs = dynamically generated web pages

```text
User  -->  HTTP Request  -->   Application Server  -->  Servlet Container  
                                                               |
                                                               V   
User  <--  HTTP Response  <--  Application Server    <--   Servlet(s)  
```
![servlets-flowchart](servlets-flowchart.jpg)

#### JavaServlet References
[Java Servlet Technology Overview](https://www.oracle.com/java/technologies/servlet-technology.html)
[Introduction to Servlets - Video Tutorial](https://www.edureka.co/blog/java-servlets)
[Servlet Documentation - Oracle](https://javaee.github.io/servlet-spec/downloads/servlet-3.1/Final/servlet-3_1-final.pdf)

### Apache Tomcat

Application server:
Runs servlet and JSP-based web apps
- **Open-source** implementation of the Java Servlet, JSPs, Java Expression Language and WebSocket technologies.
- default port = **8080**

### Apache Tomcat References
[Apache Tomcat 9 Docs](https://tomcat.apache.org/tomcat-9.0-doc/)
[Apache Tomcat 9 Configuration Reference](https://tomcat.apache.org/tomcat-9.0-doc/config/index.html)