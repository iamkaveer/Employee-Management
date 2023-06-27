# Employee Management
## Project Title: Employee Management System using Spring Boot
### Project Description: 
The Employee Management System using Spring Boot is a web-based application designed to streamline the management of employee data for an organisation. This application provides an easy-to-use interface for HR personnel to manage employee information such as personal details, job roles, salary information, and more. The application also allows employees to view their own information and make updates to their personal details.

### Features:
1. Employee Record Management: The system allows the HR department to manage employee records such as personal information, job roles, salary details, and more.
2. Employee Self-Service: The system allows employees to view their own personal information and make updates to their profiles.
   
### Technology Stack:
1. Spring Boot: Java-based framework for building the application.
2. Spring MVC: Provides a Model-View-Controller architecture for managing web requests.
3. Hibernate/JPA: ORM (Object-Relational Mapping) framework for database interactions.
4. MySQL: Relational database management system for storing employee data.

## Controllers
1. employee-self-service-controller : Handles employee profile update request
2. employee-controller : Handles employee request such as create, update , delete, get etc

## Service
1. EmolyeeService : Handles employee business logic.

## Repository
1. EmployeeRepository : Communicates with the database for employee-related operations.

## Data Model
1. Employee

## Screenshots
![Screenshot (194)](https://github.com/iamkaveer/Employee-Management/assets/41718548/34a8799d-1f47-4d21-a1a8-c7565eb69f90)

### To deploy a Spring Boot project on AWS using RDS (Relational Database Service) and Elastic Beanstalk, you can follow these steps:

1. Set up RDS:
   
   1.1 Create an RDS instance in the AWS Management Console. Choose the desired database engine (e.g., MySQL) and configure the necessary settings, such as 
        database name, username, and password
   
   1.2 Make note of the RDS endpoint, database name, username, and password as you'll need them for the application configuration.
   
2. Configure your Spring Boot application:

   2.1 Update the application.properties or application.yml file in your Spring Boot project to include the necessary database configuration.

3. Build an executable JAR or WAR file:

   3.1 Use Maven or Gradle to build an executable JAR or WAR file of your Spring Boot project. Run the appropriate command based on your build tool.

4. Set up Elastic Beanstalk:
   
   4.1 Open the AWS Management Console and navigate to Elastic Beanstalk.
   
   4.2 Click on "Create New Application" and provide a name and description for your application.

   4.3 Choose the platform as "Java" and the platform branch as the appropriate Java version.

   4.4 Select "Upload your code" and upload the JAR or WAR file generated in the previous step.
   
5. Configure Elastic Beanstalk environment
6. Review and launch the environment
