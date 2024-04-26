# Human Resources Management API


In this project, I developed a backend application to meet the needs of the Human Resources department of any company. The project was divided into several phases. In the initial phase,
I conducted a thorough analysis of the application requirements and designed the data model. The subsequent phases focused on implementing features such as employee management, password management, and leave request handling. 
I also implemented an approval mechanism for leave requests, allowing managers to approve or reject requests. 

## Technologies Used

- Java 17
- Spring Boot 3
- Maven
- sql2o
- MySQL Latest

## Requirements

- Java 17 JDK must be installed.
- Maven must be installed.
- MySQL must be installed and appropriate settings must be made in the `application.properties` file.

## Installation

1. Create a MySQL database and update the connection information in the `application.properties` file.

2. Start the project by running the following command in the project directory:

   ```bash
   mvn spring-boot:run

## Usage
- After starting the project, the application will run at http://localhost:8080.
- You can use the RESTful APIs to add employees to the system, change their passwords, request leaves, and more.
