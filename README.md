# Selenium-Cucumber-BDD Framework 🥒

Welcome to the Selenium-Cucumber-BDD framework repository! This project is designed to provide a scalable and easy-to-use framework for automated testing of web applications using Selenium and Cucumber.

## Features ✨

- **Page Object Model (POM) Design Pattern**
- **PageFactory Implementation**
- **Easy to Use** with simple commands to run tests
- **Scalable and Maintainable** framework
- **Support for Docker** to run tests in isolated containers

## Getting Started 🚀

### Prerequisites

- Java JDK 11 or above
- Maven 3.6 or above
- ChromeDriver or GeckoDriver installed and set in your PATH
- Docker (optional, for running tests in containers)

### Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/YehorYehorychev/Selenium-Cucumber.git
   cd Selenium-Cucumber

   Install dependencies
## Install dependencies

`` mvn clean install ``

## Running Tests

### You can run the tests using different methods:

### Using TestNGRunner class

- Open your IDE (e.g., IntelliJ IDEA or Eclipse).
- Navigate to src/test/java/com/yehorychev/runner/TestNGRunner.java.
- Right-click on the TestNGRunner class and select Run 'TestNGRunner'.

### Using Maven

Run specific tagged tests

``
mvn clean test -Dcucumber.filter.tags="@PlaceOrder" -Dbrowser=chrome
``
Run all tests

``
mvn clean test
``

### Running Tests in Docker

Build Docker Image

``
docker build -t selenium-cucumber .
``

### Run Docker Container

``
docker run -it selenium-cucumber
``

Project Structure 📂
```
Selenium-Cucumber/
├── .idea/
├── logs/
├── src/
│ ├── main/
│ │ └── resources/
│ │ └── log4j2.xml
│ └── test/
│ ├── java/
│ │ └── com/
│ │ └── yehorychev/
│ │ ├── features/
│ │ │ ├── checkout.feature
│ │ │ └── searchProduct.feature
│ │ ├── pageObjects/
│ │ │ ├── CheckoutPage.java
│ │ │ ├── LandingPage.java
│ │ │ ├── OffersPage.java
│ │ │ └── PageObjectManager.java
│ │ ├── runner/
│ │ │ ├── FailedTestRunner.java
│ │ │ └── TestNGRunner.java
│ │ ├── stepDefinitions/
│ │ │ ├── CheckoutPageStepDefinitions.java
│ │ │ ├── Hooks.java
│ │ │ ├── LandingPageStepDefinitions.java
│ │ │ └── OfferPageStepDefinitions.java
│ │ └── utils/
│ │ ├── GenericUtils.java
│ │ ├── TestBase.java
│ │ └── TestContextSetup.java
│ └── resources/
│ ├── extent.properties
│ └── global.properties
├── target/
│ └── test-output/
├── .gitignore
├── pom.xml
└── README.md
```

Contributing 🤝
Contributions are always welcome! Please feel free to submit a Pull Request.

Contact 📧
Yehor Yehorychev - egor57899@gmail.com


