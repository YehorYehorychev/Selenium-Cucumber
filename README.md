# Selenium-Cucumber-BDD Framework 🥒

Welcome to the Selenium-Cucumber-BDD framework repository! This project is designed to provide a scalable and easy-to-use framework for automated testing of web applications using Selenium and Cucumber.

## Features ✨

- **Page Object Model (POM) Design Pattern**
- **PageFactory Implementation**
- **Easy to Use** with simple commands to run tests
- **Scalable and Maintainable** framework
- **Support for Docker 🐳** and Selenium Grid to run tests in isolated containers
- **Logging with log4j2** for detailed test execution logs
- **Beautiful Spark Reports** for test results visualization

## Getting Started 🚀

### Prerequisites 

- Java JDK 11 or above
- Maven 3.6 or above
- Docker or Docker Desktop (optional, for running tests in containers)

### Installation

1. **Clone the repository**
   ```
   git clone https://github.com/YehorYehorychev/Selenium-Cucumber.git
   cd Selenium-Cucumber

## Install dependencies

```
 mvn clean install
```

## Running Tests

### You can run the tests using different methods:

### Using TestNGRunner class

- Open your IDE (e.g., IntelliJ IDEA or Eclipse).
- Navigate to src/test/java/com/yehorychev/runner/TestNGRunner.java.
- Right-click on the TestNGRunner class and select Run 'TestNGRunner'.

### Using Maven

Run specific tagged tests

```
mvn clean test -Dcucumber.filter.tags="@PlaceOrder" -Dbrowser=chrome
```

Run all tests

```
mvn clean test
```

### Running Tests in Docker 🐳

- Run Docker Desktop

1. Build a ``.jar`` file

```
 mvn clean package -DskipTests
```

Build Docker Image

```
docker build -t selenium-cucumber .
```

### Run Selenium Grid

```
docker-compose up
```

Run Tests

To run your tests inside the Docker container on Selenium Grid, use the ``TestNGRunner`` class or run ``mvn clean test``

Project Structure 📂
```
Selenium-Cucumber/
├── src/
│   ├── main/
│   │   └── resources/                   # Contains log4j2.xml for logging configuration
│   └── test/
│       ├── java/
│       │   └── com.yehorychev/
│       │       ├── features/            # Contains .feature files for Cucumber scenarios
│       │       ├── pageObjects/         # Contains Page Object Model classes
│       │       ├── runner/              # Contains TestNGRunner and FailedTestRunner classes
│       │       ├── stepDefinitions/     # Contains step definition classes for Cucumber
│       │       └── utils/               # Contains utility classes like TestBase, TestContextSetup, and GenericUtils
│       └── resources/                   # Contains configuration files (extent.properties, global.properties)
├── target/                      # Generated files from build and test processes
├── test-output                  # Test output files/reports
├── Dockerfile                   # Dockerfile for building the project image
├── docker-compose.yml           # Docker Compose file for setting up Selenium Grid
├── .gitignore                   # Git ignore file
├── pom.xml                      # Maven Project Object Model file
└── README.md                    # Project README file

```

Contributing 🤝
Contributions are always welcome! Please feel free to submit a Pull Request.

Contact 📧
Yehor Yehorychev - egor57899@gmail.com


