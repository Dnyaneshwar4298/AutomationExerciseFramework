# 🚀 Automation Exercise Test Automation Framework

A **Hybrid Test Automation Framework** built using **Java, Selenium WebDriver, TestNG, Cucumber BDD, Maven, and Page Object Model (POM)** for automating the [Automation Exercise](https://automationexercise.com/) e-commerce application.

The framework is designed with reusable page objects, common browser/wait keywords, configuration management, Cucumber step definitions, listeners, screenshots, logging, and test reporting.

---

## 👨‍💻 Author

**Dnyaneshwar Todmal**
QA Automation Engineer

---

## 📌 Project Overview

This project automates important functional and end-to-end scenarios of the **Automation Exercise** website.

### Application Under Test

**Automation Exercise**
https://automationexercise.com/

### Automated Areas

* User Signup / Registration
* Login
* Account Information
* Product Validation
* Product Details
* Contact Us
* Form Submission
* File Upload
* Screenshot capture
* Cucumber BDD scenarios
* TestNG-based execution
* Allure reporting support

---

# 🛠️ Technology Stack

| Technology             | Purpose                       |
| ---------------------- | ----------------------------- |
| **Java 17**            | Programming Language          |
| **Selenium WebDriver** | Web UI Automation             |
| **TestNG**             | Test Execution & Assertions   |
| **Cucumber BDD**       | Behavior Driven Development   |
| **Maven**              | Build & Dependency Management |
| **WebDriverManager**   | Browser Driver Management     |
| **REST Assured**       | API Automation Support        |
| **Allure**             | Test Reporting                |
| **Log4j2**             | Logging                       |
| **Git / GitHub**       | Version Control               |

---

# 🏗️ Framework Architecture

The framework combines:

* **Page Object Model (POM)**
* **Cucumber BDD**
* **TestNG**
* **Reusable Keyword Methods**
* **Utility Classes**
* **Configuration-driven execution**
* **TestNG Listener**
* **Screenshot Utility**
* **Allure Reporting**

### Execution Flow

```text
Feature File / Test Class
          ↓
Step Definitions / Test Methods
          ↓
Page Objects
          ↓
Reusable Keywords & Utilities
          ↓
Selenium WebDriver
          ↓
Automation Exercise Application
          ↓
TestNG / Cucumber
          ↓
Reports + Screenshots + Logs
```

---

# 📁 Project Structure

```text
AutomationExerciseFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   ├── baseClass.java
│   │   │   │   └── Hooks.java
│   │   │   │
│   │   │   ├── keywords
│   │   │   │   ├── browserKeywords.java
│   │   │   │   └── waitFor.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── homePage.java
│   │   │   │   ├── loginPage.java
│   │   │   │   ├── signupPage.java
│   │   │   │   ├── AccountInformationPage.java
│   │   │   │   └── productPage.java
│   │   │   │
│   │   │   ├── stepdefinations
│   │   │   │   ├── CommonSteps.java
│   │   │   │   ├── SignupSteps.java
│   │   │   │   ├── ProductSteps.java
│   │   │   │   └── ContactUsStepDefinition.java
│   │   │   │
│   │   │   └── utility
│   │   │       ├── ConfigReader.java
│   │   │       ├── TestData.java
│   │   │       ├── Screenshotutil.java
│   │   │       └── AdHandler.java
│   │   │
│   │   └── resources
│   │       ├── config.properties
│   │       └── FeatureFiles
│   │           ├── Signup.feature
│   │           ├── productPage.feature
│   │           └── contactus.feature
│   │
│   └── test
│       └── java
│           ├── test
│           │   ├── loginTest.java
│           │   ├── sinupTest.java
│           │   ├── productTesting.java
│           │   └── contactUsFeatureTest.java
│           │
│           ├── runner
│           │   └── TestRunner.java
│           │
│           └── listeners
│               └── TestListener.java
│
├── screenshots/
├── allure-results/
├── test-output/
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

# 🧩 Framework Components

## 1. Base Package

The `base` package contains common test setup and Cucumber hooks.

### `baseClass.java`

Provides common WebDriver/browser initialization and setup functionality.

### `Hooks.java`

Handles Cucumber lifecycle operations such as setup and cleanup around scenarios.

---

## 2. Page Object Model

The framework follows the **Page Object Model (POM)** design pattern.

Each application page has a separate Java class containing:

* Web elements
* Locators
* Page actions
* Reusable business methods

### Benefits of POM

* Reduces code duplication
* Improves maintainability
* Improves readability
* Centralizes locators
* Promotes reusable methods
* Makes UI changes easier to handle

---

# 3. Keyword Package

The `keywords` package contains reusable Selenium operations.

### `browserKeywords.java`

Contains reusable browser and element interaction operations.

### `waitFor.java`

Provides reusable wait functionality for synchronizing test execution with the web application.

This avoids repeatedly writing common Selenium operations across test classes.

---

# 4. Cucumber BDD

The project uses **Cucumber BDD** to represent scenarios in Gherkin format.

Feature files are stored under:

```text
src/main/resources/FeatureFiles/
```

Current feature files include:

```text
Signup.feature
productPage.feature
contactus.feature
```

### Example

```gherkin
Feature: Product validation

Scenario: Verify products are visible
  Given user is on the home page
  When user navigates to products
  Then all products should be displayed
```

Cucumber maps these Gherkin steps to Java step-definition classes.

---

# 5. TestNG

TestNG is used for:

* Test execution
* Assertions
* Test lifecycle management
* Listener integration
* Test suite execution

Test classes are maintained under:

```text
src/test/java/test/
```

The project also contains a Cucumber TestNG runner:

```text
src/test/java/runner/TestRunner.java
```

---

# 6. Configuration Management

Test configuration is maintained in:

```text
src/main/resources/config.properties
```

Example:

```properties
browser=chrome
baseUrl=https://automationexercise.com
explicitWait=15
```

The `ConfigReader` utility reads configuration values so that environment-specific settings do not need to be hard-coded throughout the framework.

---

# 7. Utility Classes

The `utility` package provides reusable framework-level functionality.

### `ConfigReader.java`

Reads values from the configuration file.

### `TestData.java`

Provides reusable test data.

### `Screenshotutil.java`

Captures screenshots during test execution.

### `AdHandler.java`

Provides handling for advertisement/pop-up related elements encountered during execution.

---

# 8. Screenshot on Failure

The framework includes screenshot support for test failures.

Screenshots are stored under:

```text
screenshots/
```

Screenshots help with debugging and failure analysis.

---

# 9. Logging

The project uses **Log4j2** for test execution logging.

Logging helps to:

* Track execution flow
* Debug failures
* Identify important framework events
* Simplify troubleshooting

---

# 10. Reporting

The framework supports multiple reporting outputs.

### Cucumber Reports

Cucumber reports can be generated under:

```text
target/
```

### Allure Results

Allure result files are generated under:

```text
allure-results/
```

### TestNG Reports

TestNG execution output is available under:

```text
test-output/
```

---

# ▶️ How to Run the Project

## Prerequisites

Make sure the following are installed:

* Java JDK 17+
* Maven
* Git
* Chrome browser
* Eclipse / IntelliJ IDEA

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## Clone the Repository

```bash
git clone <your-github-repository-url>
cd AutomationExerciseFramework
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Tests

```bash
mvn test
```

You can also execute the project using:

```text
testng.xml
```

---

# 📊 Reports

After execution, check:

### TestNG

```text
test-output/
```

### Cucumber

```text
target/
```

### Allure

```text
allure-results/
```

To generate and open an Allure report:

```bash
allure serve allure-results
```

---

# 🔄 Git Workflow

Typical workflow used for this project:

```bash
git status
git add .
git commit -m "Update automation framework"
git push origin main
```

---

# 🧪 Test Coverage

| Module              | Coverage |
| ------------------- | -------- |
| Signup              | ✅        |
| Login               | ✅        |
| Account Information | ✅        |
| Products            | ✅        |
| Product Details     | ✅        |
| Contact Us          | ✅        |
| File Upload         | ✅        |
| Screenshot Capture  | ✅        |
| Cucumber BDD        | ✅        |
| TestNG              | ✅        |
| Allure Reporting    | ✅        |
| Logging             | ✅        |

---

# 🚀 Future Enhancements

The framework can be further enhanced with:

* Cross-browser execution
* Parallel execution
* Environment-based configuration
* CI/CD integration with Jenkins
* API + UI combined test flows
* Docker execution
* Improved test data management
* Retry mechanism for failed tests
* Enhanced Allure attachments
* Selenium Grid / BrowserStack execution

---

# 🎯 Key Framework Benefits

* **Reusable** – Common operations are centralized.
* **Maintainable** – POM keeps locators and page actions organized.
* **Scalable** – New pages and scenarios can be added easily.
* **Readable** – Cucumber scenarios are written in business-readable language.
* **Debuggable** – Logging and screenshots help identify failures.
* **Reportable** – TestNG, Cucumber, and Allure reporting support is available.
* **Maven-based** – Dependencies and execution are managed through Maven.

---

# ⭐ Project Highlights

**Java + Selenium + TestNG + Cucumber + Maven + POM + Allure + Log4j2**

This project demonstrates a practical and maintainable UI automation framework suitable for real-world QA automation projects and interview demonstrations.

---

## 📬 Contact

**Dnyaneshwar Todmal**
QA Automation Engineer
