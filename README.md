# 🚀 Automation Exercise Test Automation Framework

A **Hybrid Test Automation Framework** built using **Java, Selenium WebDriver, TestNG, Cucumber BDD, Maven, and Page Object Model (POM)**.

This framework is designed to automate key functionalities of the [Automation Exercise](https://automationexercise.com/) e-commerce application while keeping the code **reusable, maintainable, scalable, and easy to understand**.

---

## 👨‍💻 Author

**Dnyaneshwar Todmal**
QA Automation Engineer

---

## 📌 Project Overview

This project automates important end-to-end scenarios of the **Automation Exercise** website.

### Application Under Test

**Automation Exercise**
https://automationexercise.com/

### Main Functionalities Automated

* User Registration / Signup
* Login
* Product Validation
* Product Details
* Contact Us
* Form Submission
* File Upload
* Page and Element Validation
* Screenshot Capture on Test Failure
* Cucumber BDD Scenarios

---

# 🛠️ Technology Stack

| Technology                    | Purpose                       |
| ----------------------------- | ----------------------------- |
| **Java 17**                   | Programming Language          |
| **Selenium WebDriver 4.45.0** | Web UI Automation             |
| **TestNG 7.12.0**             | Test Execution & Assertions   |
| **Cucumber 7.18.1**           | BDD / Gherkin                 |
| **Maven**                     | Build & Dependency Management |
| **WebDriverManager 6.2.0**    | Browser Driver Management     |
| **REST Assured 5.5.6**        | API Automation Support        |
| **Allure 2.29.1**             | Test Reporting                |
| **Git & GitHub**              | Version Control               |
| **Jenkins**                   | CI/CD Execution               |

---

# 🏗️ Framework Architecture

The framework follows a combination of:

* **Page Object Model (POM)**
* **Page Factory**
* **Cucumber BDD**
* **TestNG**
* **Reusable Keyword Methods**
* **Utility Classes**
* **Test Listeners**
* **Configuration-driven execution**

### High-Level Execution Flow

```text
Feature File
     ↓
Step Definitions
     ↓
Page Objects
     ↓
Reusable Keywords / Utilities
     ↓
Selenium WebDriver
     ↓
Web Application
     ↓
TestNG / Cucumber
     ↓
Reports + Screenshots
```

---

# 📁 Project Structure

```text
AutomationExerciseFramework
│
├── src
│   │
│   ├── main
│   │   ├── java
│   │   │   │
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
├── screenshots
├── allure-results
├── test-output
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

# 🧩 Framework Components

## 1. Base Package

The `base` package contains the common setup required before executing tests.

### `baseClass.java`

Responsible for common WebDriver initialization and browser-related setup.

It provides a common foundation for test classes instead of repeating browser setup code in every test.

### `Hooks.java`

Used with Cucumber to manage test execution setup and cleanup.

---

# 2. Page Object Model

The framework follows the **Page Object Model (POM)** design pattern.

Each application page has a dedicated Java class containing:

* Web elements
* Locators
* Page actions
* Business methods

### Example

```java
public void enterEmail(String email) {
    emailField.sendKeys(email);
}
```

Instead of writing Selenium code directly inside the test, the test can simply call:

```java
loginPage.enterEmail(email);
```

### Benefits of POM

* Reduces code duplication
* Improves maintainability
* Improves readability
* Makes locator changes easier
* Encourages reusable methods

---

# 3. Keyword Package

The `keywords` package contains reusable Selenium operations.

Examples include:

```text
Browser operations
Wait operations
Element interactions
```

The purpose is to avoid repeatedly writing the same Selenium code throughout the framework.

For example:

```text
Test
 ↓
Page Method
 ↓
Keyword Method
 ↓
Selenium WebDriver
```

This makes the framework easier to maintain and extend.

---

# 4. Cucumber BDD

The framework uses **Cucumber BDD** to describe test scenarios in business-readable language.

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
Feature: User Signup

Scenario: Create a new user account

Given user is on the Automation Exercise website
When user clicks on Signup
And user enters valid registration details
Then user should be successfully registered
```

This makes test scenarios understandable to both:

* Technical team members
* Non-technical stakeholders

---

# 5. Step Definitions

Step definitions connect Cucumber feature-file steps with Java automation code.

For example:

```text
Feature File
     ↓
Step Definition
     ↓
Page Object
     ↓
Selenium
```

The framework contains step-definition classes for:

* Signup
* Product
* Contact Us
* Common actions

---

# 6. Utility Package

The `utility` package contains reusable helper classes.

### `ConfigReader`

Reads configuration values from:

```text
config.properties
```

This avoids hardcoding configuration values inside test classes.

### `Screenshotutil`

Captures screenshots during test execution, especially when a test fails.

Screenshots are stored under:

```text
screenshots/
```

### `TestData`

Provides reusable test data.

### `AdHandler`

Handles unwanted advertisements/popups that may interfere with Selenium execution.

---

# 7. TestNG

TestNG is used for:

* Test execution
* Assertions
* Test organization
* Test suite execution
* Listener integration

The TestNG suite is configured in:

```text
testng.xml
```

---

# 8. Test Listener

The framework contains a custom:

```text
TestListener.java
```

The listener can be used to perform actions based on test execution events.

For example:

```text
Test Started
     ↓
Test Execution
     ↓
PASS / FAIL
     ↓
Screenshot / Reporting
```

---

# ⚙️ Configuration

Framework configuration is maintained in:

```text
src/main/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://automationexercise.com/
```

This approach keeps configuration separate from the automation code.

To change the browser, the configuration can be updated without modifying the test logic.

---

# 🧪 Automated Test Scenarios

## Signup

* Navigate to Signup
* Enter user details
* Create a new account
* Validate registration

## Login

* Login with valid credentials
* Validate login functionality
* Logout

## Product

* Verify products
* Open product details
* Validate product information
* Perform product-related actions

## Contact Us

* Open Contact Us page
* Enter contact information
* Upload a file
* Submit the form
* Validate success message

---

# ▶️ How to Run the Project

## Prerequisites

Make sure the following are installed:

* Java 17 or higher
* Maven
* Git
* Chrome / Firefox / Edge
* IDE such as Eclipse or IntelliJ IDEA

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

# 📦 Install Dependencies

Run:

```bash
mvn clean install
```

Maven will download the required dependencies from `pom.xml`.

---

# ▶️ Run Tests

### Using Maven

```bash
mvn test
```

### Using TestNG

Open:

```text
testng.xml
```

Then:

```text
Right Click
     ↓
Run As
     ↓
TestNG Suite
```

---

# 🥒 Running Cucumber Tests

Cucumber tests can be executed through:

```text
TestRunner.java
```

The runner connects:

```text
Feature Files
      ↓
Step Definitions
      ↓
Test Execution
```

---

# 📊 Test Reports

## TestNG Report

After execution, TestNG results are available under:

```text
test-output/
```

---

## Allure Report

After test execution, Allure result files are generated in:

```text
allure-results/
```

Generate the report using:

```bash
allure serve allure-results
```

This opens the Allure report in the browser.

The report provides information such as:

* Passed tests
* Failed tests
* Skipped tests
* Test duration
* Test details

---

# 📸 Screenshots

Screenshots captured during execution are stored in:

```text
screenshots/
```

Screenshots are useful for debugging failed automation scenarios.

---

# 🔄 CI/CD Integration

The framework is suitable for execution through **Jenkins**.

Typical CI/CD flow:

```text
Developer Push
      ↓
GitHub
      ↓
Jenkins
      ↓
Maven Build
      ↓
Test Execution
      ↓
Test Reports
      ↓
Failure Screenshots
```

A Jenkins job can execute:

```bash
mvn clean test
```

This allows the automation suite to run automatically as part of a CI/CD pipeline.

---

# 🔑 Key Framework Advantages

### Reusable

Common Selenium operations are centralized into reusable methods.

### Maintainable

Page Objects separate locators and application actions from test logic.

### Scalable

New pages, features, and scenarios can be added without changing the complete framework.

### Readable

Cucumber feature files describe scenarios in simple business language.

### Configurable

Browser and application settings are maintained separately.

### Debuggable

Screenshots and reports help identify failed test cases.

---

# 🎯 Design Principles Used

The framework follows several automation best practices:

* Page Object Model
* Page Factory
* Separation of Test and Page Logic
* Reusable Methods
* Configuration Management
* Explicit Waits
* TestNG Assertions
* Cucumber BDD
* Screenshot Capture
* Reporting
* Maven Dependency Management
* Version Control using Git

---

# 💡 Why This Framework?

This project demonstrates practical knowledge of modern QA automation concepts including:

```text
Java
+
Selenium
+
TestNG
+
Cucumber BDD
+
POM
+
Maven
+
Git
+
Jenkins
+
Reporting
```

It is designed to demonstrate how a real-world UI automation framework can be structured for **maintainability, reusability, and continuous integration**.

---

# 👨‍💻 Skills Demonstrated

* Manual Testing
* Automation Testing
* Selenium WebDriver
* Java
* TestNG
* Cucumber BDD
* Page Object Model
* Maven
* Git & GitHub
* Jenkins
* API Testing
* REST Assured
* SQL
* Allure Reporting

---

## ⭐ GitHub Repository

https://github.com/Dnyaneshwar4298/AutomationExerciseFramework

If you find this project useful, feel free to ⭐ the repository.
