# Spring boot security
## Get Started
* setup JAVA 17
* setup postgresql
* clone project and start
```sh
    git clone https://github.com/Sulaymon-Dev20/spring-boot-security.git
```
## Project path
```txt
spring-boot-security
├── HELP.md
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com.suyo.springauth
        │       ├── SpringAuthApplication.java
        │       ├── config
        │       │   ├── ApplicationConfig.java
        │       │   ├── JwtAuthenticationFilter.java
        │       │   └── SecurityConfiguration.java
        │       ├── controller
        │       │   ├── AuthController.java
        │       │   └── DemoController.java
        │       ├── models
        │       │   ├── AuthResponse.java
        │       │   ├── LoginRequest.java
        │       │   └── RegisterRequest.java
        │       ├── repository
        │       │   └── UserRepository.java
        │       ├── service
        │       │   ├── AuthService.java
        │       │   └── JwtService.java
        │       └── user
        │           └── User.java
        └── resources
            ├── application.properties
            ├── static
            └── templates
```
