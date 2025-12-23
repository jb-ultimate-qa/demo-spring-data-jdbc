## Simple demo project with Spring Data JDBC

- A set of entities with different combinations (see `roots` package)
- Spring Data 4.0 features
- CRUD repositories and command line runners separated by profiles (see `runner` package)
- Flyway and Liquibase scripts + sql scripts for PostgreSQL with data (`resources/db`)
- build.gradle


To run the app, you need to set a desired profile in `DemoJdbcApplication.java`


Another branches:
- `springboot3.5` contains a project on Spring Data JDBC 3.5. It is almost the same but without JDBC features of 4.0