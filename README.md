# TaskFlow: A Spring Boot Project Management & Task Tracker

## 🚀 Overview

**TaskFlow** is a robust web application designed to streamline project management and task tracking. Built with the powerful **Spring Boot** framework, it offers a complete solution for creating and managing projects, as well as organizing tasks within each project. Whether you're coordinating a team or personal objectives, TaskFlow provides an intuitive and efficient interface.(still in progress)

## ✨ Key Features

- **Project Management:**
    
    - **Create Projects:** Define new projects with a `Name`, `Description`, `Start Date`, `End Date`, and `Status` (e.g., `PLANNING`, `IN_PROGRESS`, `COMPLETED`).
        
    - **View Project Details:** Access a comprehensive overview of each project, including its associated tasks.
        
    - **Update Projects:** Modify project details as needs evolve.
        
    - **Delete Projects:** Remove projects when they are no longer needed.
        
- **Task Management:**
    
    - **Create Tasks:** Add tasks within specific projects, including a `Title`, `Content`, `Due Date`, `Status` (e.g., `PENDING`, `IN_PROGRESS`, `DONE`), and `Priority` (e.g., `HIGH`, `MEDIUM`, `LOW`).
        
    - **View Task Details:** Get a detailed look at individual tasks.
        
    - **Update Tasks:** Edit task information and progress.
        
    - **Delete Tasks:** Remove completed or obsolete tasks.
        

## 🛠️ Technologies Used

**Backend:**

- **Spring Boot 3.x:** The core framework for rapid application development.
    
- **Spring Data JPA:** For simplified data access and persistence layer.
    
- **Hibernate:** The ORM (Object-Relational Mapping) framework used by Spring Data JPA.

**Database:**

- **MySQL:** A powerful and widely used relational database.
    

**Frontend:**

- **Thymeleaf:** A modern server-side Java template engine for elegant web view development.
- **Bootstrap 5:** A popular CSS framework for responsive and mobile-first frontend design.
- **Custom CSS:** Enhancements for a unique look and feel.

**Build Tool:**
- **Maven:** For project management and dependency management.

## ⚙️ Architecture & Best Practices

TaskFlow is built following modern Spring Boot best practices to ensure maintainability, scalability, and security:

- **Layered Architecture:**
    
    - **Controllers:** Handle incoming HTTP requests and return appropriate views or data.
        
    - **Services:** Implement business logic, orchestrating interactions between controllers and the data access layer. Services are injected using **Dependency Inversion** (Interfaces + Implementation).
        
    - **Repositories (DAO):** Manage data persistence operations, interacting directly with the database.
        
- **Entities:** JPA entities represent the database tables and define the structure of your data.
    
- **Data Transfer Objects (DTOs):**
    
    - **Request DTOs:** Used for inbound data (e.g., form submissions) to validate and map incoming data safely.
        
    - **Response DTOs:** Used for outbound data (e.g., displaying data on web pages) to expose only necessary information, enhancing security and preventing over-exposure of entity details.
        
- **Configuration:** Dedicated configuration classes manage application-wide settings and bean definitions.
    
## 📞 Contact

- Belarbi nasreddine - [My Email](belarbi.nasrddine@gmail.com)
- Project Link: [/nasronasro/SpringProject](https://github.com/nasronasro/SpringProject) 