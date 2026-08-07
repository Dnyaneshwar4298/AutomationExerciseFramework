# AutomationExerciseFramework

# 👨‍💻 Author

**Dnyaneshwar Todmal**

QA Automation Engineer


# 🚀 AutomationExercise Framework

A Hybrid Test Automation Framework developed using **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)** to automate the Automation Exercise E-Commerce application.

The framework is designed following industry best practices and includes reusable components, logging, reporting, screenshots, data-driven testing, cross-browser execution, and CI/CD support.

---

# 📌 Project Overview

This project automates the major functionalities of the Automation Exercise website.

Website:
https://automationexercise.com/

The framework covers end-to-end automation of:

- User Registration
- Login
- Product Search
- Product Details
- Add to Cart
- Contact Us
- Validation Scenarios
- Screenshot Capture
- Reporting

---

# 🛠 Tech Stack

| Technology | Version |
|------------|----------|
| Java | 17 |
| Selenium WebDriver | 4.45.0 |
| TestNG | 7.12.0 |
| Maven | Latest |
| WebDriverManager | 6.2.0 |
| Rest Assured | 5.5.6 |
| Allure Report | 2.29.1 |
| Cucumber | 7.20.1 |
| Log4j2 | Latest |
| Git | Version Control |
| Jenkins | CI/CD |

---

# ✨ Framework Features

✔ Hybrid Automation Framework

✔ Page Object Model (POM)

✔ Page Factory

✔ TestNG

✔ Maven Project Structure

✔ Data-Driven Testing

✔ Cross Browser Execution

✔ Screenshot on Failure

✔ Allure Reporting

✔ Extent Reporting

✔ Log4j2 Logging

✔ Utility Classes

✔ Reusable Keyword Methods

✔ WebDriverManager Integration

✔ Jenkins Ready

---

# 📁 Project Structure

```
AutomationExerciseFramework
│
├── src
│   ├── main
│   │
│   ├── java
│   │   ├── base
│   │   ├── keywords
│   │   ├── pages
│   │   ├── utility
│   │   └── listeners
│   │
│   └── resources
│       ├── config.properties
│       ├── log4j2.xml
│       └── testdata
│
├── src/test/java
│      ├── loginTest
│      ├── signupTest
│      ├── productTesting
│      ├── contactUsFeatureTest
│      └── listeners
│
├── screenshots
├── allure-results
├── test-output
├── pom.xml
├── testng.xml
└── README.md
```

---

# 📦 Design Pattern

The framework follows **Page Object Model (POM)**.

Every web page has:

- Web Elements
- Methods
- Business Actions

Example

```
LoginPage.java

@FindBy(id="email")
WebElement email;

public void enterEmail(String mail){
    email.sendKeys(mail);
}
```

Benefits

- Easy Maintenance
- Code Reusability
- Better Readability
- Less Duplication

---

# 🔧 Framework Components

## Base Class

Responsible for

- Browser Initialization
- Driver Setup
- Launch URL
- Close Browser

---

## Page Classes

Contains

- Locators
- Business Methods
- Page Actions

Example

- HomePage
- LoginPage
- ProductPage
- ContactUsPage

---

## Utility Classes

Utility package contains reusable methods like

- Config Reader
- Screenshot Utility
- Excel Utility
- Wait Utility
- Browser Utility

---

## Keyword Classes

Reusable Selenium keywords

Examples

- click()
- sendKeys()
- selectDropdown()
- waitForElement()
- mouseHover()
- switchWindow()
- verifyText()

---

## Listeners

Implements TestNG Listener

Features

- Screenshot on Failure
- Logging
- Report Generation

---

# ⚙ Configuration

All project configurations are stored inside

```
src/test/resources/config.properties
```

Example

```
browser=chrome
url=https://automationexercise.com/
implicitWait=10
```

Changing browser requires updating only this file.

---

# ▶ Running the Project

## Clone Repository

```
git clone https://github.com/Dnyaneshwar4298/AutomationExerciseFramework.git
```

---

## Open Project

Import as

```
Existing Maven Project
```

---

## Install Dependencies

```
mvn clean install
```

---

## Execute TestNG Suite

```
Right Click

testng.xml

Run As

TestNG Suite
```

OR

```
mvn test
```

---

# 🌐 Cross Browser Execution

Supported browsers

- Chrome
- Firefox
- Edge

Browser can be changed from

```
config.properties
```

Example

```
browser=firefox
```

---

# 📊 Reporting

## TestNG Report

Generated under

```
test-output/
```

---

## Allure Report

Generate

```
allure serve allure-results
```

---

## Extent Report

Generated automatically after execution.

Contains

- Pass
- Fail
- Skip
- Execution Time
- Screenshots

---

# 📷 Screenshot Capture

Whenever a test fails

Framework automatically captures screenshot

Stored in

```
screenshots/
```

---

# 🧪 Test Scenarios Automated

### Login Module

- Valid Login
- Invalid Login
- Logout

---

### Registration Module

- New User Registration
- Existing User Validation

---

### Product Module

- View Products
- Search Products
- Product Details

---

### Contact Us

- Submit Contact Form
- Upload File
- Success Message Validation

---

### Validation

- Page Title
- URL
- Text Verification
- Element Visibility

---

# 📈 CI/CD

Framework supports Jenkins.

Pipeline Steps

```
Git Pull

↓

Build

↓

Run TestNG

↓

Generate Reports

↓

Publish Results
```

---

# 📋 Maven Commands

Clean Project

```
mvn clean
```

Compile

```
mvn compile
```

Execute Tests

```
mvn test
```

Package

```
mvn package
```

---

# 📚 Best Practices Followed

- Page Object Model
- Java Coding Standards
- Reusable Components
- Explicit Waits
- No Hardcoded Values
- Configuration Driven
- Modular Design
- Screenshot on Failure
- Logging
- Reporting
- Maven Dependency Management

---

# 🚀 Future Enhancements

- Docker Integration
- Selenium Grid
- BrowserStack Execution
- GitHub Actions
- Parallel Execution
- API Automation
- Database Validation
- Performance Testing using JMeter

---



### Skills

- Selenium WebDriver
- Java
- TestNG
- Maven
- Playwright (Basic)
- REST Assured (Basic)
- API Testing
- SQL
- Jenkins
- Git
- Manual Testing

GitHub

https://github.com/Dnyaneshwar4298



