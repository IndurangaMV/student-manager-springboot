# Student Registration System

A web-based Student Registration System developed using **Spring Boot, Spring Data JPA, Thymeleaf, and H2 Database** as part of COSC 32133 / BECS 32263 – Full-Stack Software Development (Lab Sheet 04), University of Kelaniya.

The application allows users to register students, view registered student records, update existing details, and delete student records through a simple web interface.

## Features

- **Student Registration:** Add new students with their full name, email, phone number, course, and age.
- **View Students:** Display all registered students in a structured table.
- **Update Student Details:** Edit and update existing student information.
- **Delete Students:** Remove student records from the database.
- **Form Validation:** Validate user inputs, including required fields, email format, phone number, and age.
- **Duplicate Email Prevention:** Prevent registration of multiple students using the same email address.
- **Database Integration:** Store and manage student records using an H2 database.
- **H2 Database Console:** Inspect database tables and execute SQL queries through the H2 web console.
- **Responsive Interface:** Simple and user-friendly web interface with custom CSS styling.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming language |
| Spring Boot | Application framework |
| Spring Web MVC | Web request handling |
| Spring Data JPA | Database operations |
| Hibernate | Object-relational mapping |
| H2 Database | Database management |
| Thymeleaf | Server-side HTML templating |
| Jakarta Validation | Form validation |
| Maven | Dependency management and build automation |
| HTML5 | Web page structure |
| CSS3 | User interface styling |
| Git & GitHub | Version control and project hosting |

## Project Architecture

The application follows a layered Spring MVC architecture.

```text
student-manager/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/studentmanager/
│   │   │   │
│   │   │   ├── controller/
│   │   │   │   └── StudentController.java
│   │   │   │
│   │   │   ├── model/
│   │   │   │   └── Student.java
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   └── StudentRepository.java
│   │   │   │
│   │   │   ├── service/
│   │   │   │   └── StudentService.java
│   │   │   │
│   │   │   └── StudentManagerApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   └── css/
│   │       │       └── style.css
│   │       │
│   │       ├── templates/
│   │       │   ├── fragments.html
│   │       │   ├── students.html
│   │       │   └── edit-student.html
│   │       │
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

### Architecture Responsibilities

| Layer | Responsibility |
|---|---|
| Model | Defines the Student entity and its validation rules. |
| Repository | Provides database access using Spring Data JPA. |
| Service | Handles student-related business logic. |
| Controller | Handles HTTP requests and coordinates application operations. |
| View | Displays the user interface using Thymeleaf templates. |

## Database Configuration

This application uses an H2 in-memory database.

Database configuration is defined in `src/main/resources/application.properties`.

```properties
spring.application.name=student-manager

spring.datasource.url=jdbc:h2:mem:studentdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false
```

**Database Details:**

- Database: H2
- Database Name: studentdb
- JDBC URL: `jdbc:h2:mem:studentdb`
- Username: `sa`
- Password: Empty

**Note:** The database is configured as an in-memory database. Student records are cleared when the application is stopped.

## Application Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/` | Redirects to the student registration page |
| GET | `/students` | Displays the registration form and student list |
| POST | `/students` | Registers a new student |
| GET | `/students/{id}/edit` | Opens the edit form for a student |
| POST | `/students/{id}/update` | Updates student information |
| POST | `/students/{id}/delete` | Deletes a student record |

## Input Validation

The application implements server-side validation using Jakarta Validation annotations.

| Field | Validation |
|---|---|
| Full Name | Required, maximum 100 characters |
| Email | Required, valid email format, unique |
| Phone | Required, exactly 10 digits |
| Course | Required |
| Age | Required, between 15 and 100 |

Validation errors are displayed directly on the registration and edit forms.

## Getting Started

### Prerequisites

Make sure the following software is installed:

- JDK 17 or later (JDK 21 recommended)
- IntelliJ IDEA, VS Code, or Spring Tool Suite
- Git
- A web browser

### 1. Clone the Repository

```bash
git clone https://github.com/IndurangaMV/student-manager-springboot.git
```

### 2. Navigate to the Project Directory

```bash
cd student-manager-springboot
```

### 3. Run the Application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

On Linux/macOS:

```bash
./mvnw spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run `StudentManagerApplication.java`.

### 4. Access the Application

Once the application starts successfully, open:

**Student Registration System:**

http://localhost:8080

**H2 Database Console:**

http://localhost:8080/h2-console

Use the following JDBC URL to connect:

```text
jdbc:h2:mem:studentdb
```

Username: `sa`

Password: Leave empty.

To view the registered student records, execute:

```sql
SELECT * FROM STUDENTS;
```

## Git Workflow

The project uses Git for version control and GitHub for source code hosting.

The student CRUD functionality was developed using a feature branch:

```bash
git switch -c feature/student-crud
```

Changes were committed and pushed to GitHub:

```bash
git add .
git commit -m "Add student CRUD functionality"
git push -u origin feature/student-crud
```

A Pull Request was created to merge the feature branch into the `main` branch.

## Academic Information

**Course:** COSC 32133 / BECS 32263 – Full-Stack Software Development

**Lab:** Lab Sheet 04 – Spring Boot CRUD Application with H2 Database & GitHub

**Institution:** University of Kelaniya

**Department:** Department of Statistics & Computer Science

---

Developed as part of the Full-Stack Software Development laboratory exercises.
