# Trading Data API

App for Will's internship challenge, as described here: https://github.com/WillAlvino/IntershipChallenge2022

Technologies used:
- Java
- Hibernate
- Spring Boot
- Oracle DB

# Setup

The application is supposed to run with minimal setup.

### Requisites:

- Windows 10 or 11
- Java SDK 17
- Oracle DB 21c Express

### Tutorial:

- You don't need to run any migrations, nor populate the db. That's taken care off by Spring JPA and our dataloader 
- Simply create a user in Oracle DB and reflect these changes on `src/main/resources/application.properties`
- By default, we are using the `system` user with `123` as password.
- After that, simply run the application with `spring-boot:run --debug` as parameters
