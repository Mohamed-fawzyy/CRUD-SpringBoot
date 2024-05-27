# Project Idea 🎩
This project is a Spring Boot application that demonstrates CRUD (Create, Read, Update, Delete) operations using a PostgreSQL database. The application is designed with best practices for a professional 
and maintainable codebase, including proper configuration, validation, and exception handling.

# Reach/Follow me on <br> 📫
<p align="left">
  <a href="https://www.linkedin.com/in/mohamed-fawzy-936b661b8/" target="_blank" rel="noreferrer"> <img src="https://img.icons8.com/fluency/2x/linkedin.png" alt="linkedIn" width="50" height="50"/> </a>&nbsp&nbsp
  <a href="mailto:fwzymohamed90@gmail.com" target="_blank" rel="noreferrer"> <img src="https://img.icons8.com/fluency/2x/google-logo.png" alt="googleEmail" width="50" height="50"/> </a>&nbsp&nbsp
  <a href="https://www.facebook.com/mohamed.fwzy.14" target="_blank" rel="noreferrer"> <img src="https://cdn.iconscout.com/icon/free/png-256/facebook-262-721949.png" alt="facebook" width="50" height="50"/> </a>
</p>
<br>

# Features 🚀
- CRUD operations: Create, Read, Update, and Delete operations on a Person entity.
- PostgreSQL integration: Uses PostgreSQL as the database.
- Validation: Validates input data using @Valid and @NotBlank annotations.
- Exception Handling: Global exception handling for clean error responses.

# Prerequisites 📚
- Java 17 or higher
- Maven 3.6.0 or higher
- PostgreSQL database from Docker
- Getting Started

## Clone the repository 🧑🏽‍💻
```bash
git clone https://github.com/your-username/spring-boot-crud-postgresql.git
cd spring-boot-crud-postgresql
```

### Configure the Database 💾
Create a PostgreSQL database and update the connection settings in `src/main/resources/application.properties`.
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Run a PostgreSQL container:

```sh
docker run --name postgres-db -e POSTGRES_USER=your_username -e POSTGRES_PASSWORD=your_password -e POSTGRES_DB=your_database -p 5432:5432 -d postgres
```

## Build and Run the Application 🛠

```bash
./mvnw clean install
./mvnw spring-boot:run
```

## API Endpoints 🗺
* Get all persons
  - GET `/api/v1/person`

* Get person by ID
  - GET `/api/v1/person/{id}`

* Add new person
  - POST `/api/v1/person`
  - Body:
```json
{
  "name": "John Doe"
}
```

* Update person
  - PUT `/api/v1/person/{id}`
  - Body:
```json
{
  "name": "Mohamed Fawzy"
}
```

* Delete person
  - DELETE `/api/v1/person/{id}`


# Project Structure🎢

```js
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── demo
│   │               ├── controller
│   │               │   └── PersonController.java
│   │               ├── model
│   │               │   └── Person.java
│   │               ├── datasource
│   │               │   └── PostgresDataSource.java
│   │               ├── service
│   │               │   └── PersonService.java
│   │               └── dao
│   │                   └── PersonDataAccessService.java
│   │                   └── PersonDao.java
│   └── resources
│       └── application.properties
│       └── application.yaml
│       └── db
│           └── migration
│               └── V1__PersonTable.sql
└── test
    └── java
        └── com
            └── example
                └── demo
                    └── DemoApplicationTests.java
```



# Contributing 📝
Contributions are welcome! Please fork the repository and submit a pull request.


