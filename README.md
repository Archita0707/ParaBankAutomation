# ParaBank Automation Framework

An automated test suite for the [ParaBank](https://parabank.parasoft.com/) banking application using **Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM)** design pattern.

The framework includes **data-driven testing, Extent Reports, configurable test environments, and automatic screenshot capture on test failures**.

---

## 🚀 Tech Stack & Tools

| Technology                  | Purpose                            |
| --------------------------- | ---------------------------------- |
| **Java**                    | Programming language               |
| **Selenium WebDriver**      | Web UI automation                  |
| **TestNG**                  | Test execution and test management |
| **Maven**                   | Build and dependency management    |
| **Page Object Model (POM)** | Test framework design pattern      |
| **ExtentReports**           | HTML test reporting                |
| **Apache POI**              | Excel-based data-driven testing    |
| **Git/GitHub**              | Version control                    |

---

## 📁 Project Structure

```text
ParaBankAutomation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── # Base setup, browser initialization, and teardown
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   └── # Page Object classes
│   │   │   │
│   │   │   ├── reports/
│   │   │   │   └── # Extent Report listener configuration
│   │   │   │
│   │   │   └── utils/
│   │   │       └── # ConfigReader, ExcelUtils, and helper classes
│   │   │
│   │   └── resources/
│   │       └── .gitkeep
│   │
│   └── test/
│       ├── java/
│       │   └── tests/
│       │       └── # Test case classes
│       │
│       └── resources/
│           └── config.properties
│
├── .gitignore
├── pom.xml
└── testng.xml
```

---

## ⚙️ Key Features

### 1. Page Object Model (POM)

The framework follows the **Page Object Model** design pattern to separate page locators and page-specific actions from test cases.

This improves:

* Code reusability
* Maintainability
* Readability
* Locator management
* Test scalability

---

### 2. Data-Driven Testing

Test data can be maintained in external **Excel files** and read using **Apache POI**.

This allows the same test case to execute with multiple sets of test data without modifying the test code.

For example:

```text
Username        Password
--------------------------------
validUser1      password123
validUser2      password456
invalidUser     wrongPassword
```

The test can read each row and execute the same login scenario with different credentials.

---

### 3. Configurable Environment

Global configuration values such as the application URL and browser settings are maintained using a `config.properties` file.

Example:

```properties
url=https://parabank.parasoft.com/
browser=chrome
```

This allows configuration changes without modifying the Java test classes.

---

### 4. Extent Reports

The framework integrates **ExtentReports** to generate detailed HTML test reports containing:

* Test execution status
* Pass/fail information
* Execution timestamps
* Test logs
* Failure details
* Test execution results

---

### 5. Automated Failure Screenshots

Screenshots are automatically captured whenever a test case fails.

These screenshots help with debugging issues such as:

* Incorrect page navigation
* Element not found
* Incorrect input
* Unexpected UI changes
* Synchronization problems

---

## 🛠️ Prerequisites

Make sure the following are installed before running the project:

* **JDK 17 or higher**
* **Apache Maven**
* **Google Chrome**
* **Microsoft Edge** or **Mozilla Firefox** if cross-browser testing is configured
* **Git**
* **Eclipse / IntelliJ IDEA / Visual Studio Code** (optional)

> **Note:** Recent versions of Selenium include Selenium Manager, which can automatically manage browser drivers. Therefore, manually downloading ChromeDriver may not be required.

---

## 📥 Clone the Repository

Clone the repository using:

```bash
git clone https://github.com/Archita0707/ParaBankAutomation.git
```

Navigate to the project directory:

```bash
cd ParaBankAutomation
```

---

## 📦 Install Dependencies

Maven automatically downloads the dependencies defined in `pom.xml`.

Run:

```bash
mvn clean install
```

---

## ▶️ Running the Tests

### Run the Complete Test Suite

Execute:

```bash
mvn clean test
```

Maven will execute the test suite configured in the project.

---

### Run Using TestNG

The test suite can also be executed directly from the IDE using:

```text
testng.xml
```

Open `testng.xml`, right-click, and select:

```text
Run As → TestNG Suite
```

---

## 📊 Reports

After test execution, the framework generates an **ExtentReports HTML report**.

Typical location:

```text
test-output/
└── ExtentReport.html
```

Open:

```text
ExtentReport.html
```

in a web browser to view the complete execution report.

The report provides information such as:

* Total tests executed
* Passed tests
* Failed tests
* Skipped tests
* Execution time
* Failure details
* Test logs
* Screenshots for failed tests

---

## 📸 Failure Screenshots

When a test fails, the framework automatically captures a screenshot.

The screenshot can be attached to the Extent Report to provide visual information about the state of the application at the time of failure.

Example:

```text
Test Failure
     │
     ▼
Capture Screenshot
     │
     ▼
Attach Screenshot
     │
     ▼
Extent Report
```

---

## 🧪 Test Coverage

The automation suite covers key ParaBank banking workflows such as:

* User login
* Data-driven login testing
* User registration
* Account-related workflows
* Banking transactions
* Negative test scenarios
* Cross-browser execution

> The exact test coverage depends on the test cases currently implemented in the project.

---

## 🔄 Framework Execution Flow

```text
                    TestNG
                       │
                       ▼
                  Base Test
                       │
                       ├── Browser Initialization
                       │
                       ▼
                  Page Objects
                       │
          ┌────────────┼────────────┐
          ▼            ▼            ▼
      Login Page   Home Page   Banking Pages
          │            │            │
          └────────────┼────────────┘
                       │
                       ▼
                 Test Execution
                       │
              ┌────────┼────────┐
              ▼        ▼        ▼
          Assertions   Logs   Results
                       │
                       ▼
                Extent Reports
                       │
                       ▼
             Failure Screenshot
```

---

## 🏗️ Framework Architecture

```text
                    ┌─────────────────┐
                    │     TestNG      │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │   Test Classes  │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │   Page Objects  │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │ Selenium WebDriver│
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │    ParaBank     │
                    │   Web App       │
                    └─────────────────┘

Additional Components:

ConfigReader ───────► Configuration
ExcelUtils ─────────► Test Data
ExtentReports ──────► Test Reports
Screenshot Utility ─► Failure Evidence
```

---

## 🎯 Project Objectives

The purpose of this project is to demonstrate a maintainable Selenium automation framework using commonly used automation testing practices.

The framework demonstrates:

* **Page Object Model**
* **Data-driven testing**
* **TestNG**
* **Maven**
* **External configuration**
* **Reusable utility classes**
* **Extent Reports**
* **Automated screenshot capture**
* **Structured test execution**

---

## 📚 Concepts Demonstrated

This project provides practical implementation of:

```text
Selenium WebDriver
        │
        ├── Web Element Interaction
        ├── Locators
        ├── Browser Automation
        ├── Assertions
        └── Screenshots

TestNG
        │
        ├── Test Cases
        ├── Test Suites
        ├── Annotations
        ├── Assertions
        └── Listeners

Maven
        │
        ├── Dependency Management
        ├── Build Lifecycle
        └── Test Execution

Apache POI
        │
        └── Excel Data Handling

ExtentReports
        │
        └── HTML Test Reporting
```

---

## 📌 Example Test Execution

A typical test execution follows this process:

```text
1. Start browser
       ↓
2. Open ParaBank application
       ↓
3. Load test data/configuration
       ↓
4. Navigate using Page Objects
       ↓
5. Perform test actions
       ↓
6. Validate expected results
       ↓
7. Record test result
       ↓
8. Capture screenshot if test fails
       ↓
9. Generate Extent Report
```

---

## 🔧 Configuration

The application URL and browser configuration can be modified through:

```text
src/test/resources/config.properties
```

Example:

```properties
url=https://parabank.parasoft.com/
browser=chrome
```

Depending on the framework implementation, the browser can be changed without modifying the test classes.

---

## 📂 Important Files

| File / Directory                       | Description                                  |
| -------------------------------------- | -------------------------------------------- |
| `src/main/java/base`                   | Browser setup and common test configuration  |
| `src/main/java/pages`                  | Page Object classes                          |
| `src/main/java/reports`                | ExtentReports configuration                  |
| `src/main/java/utils`                  | Reusable utility classes                     |
| `src/test/java/tests`                  | Test cases                                   |
| `src/test/resources/config.properties` | Test configuration                           |
| `pom.xml`                              | Maven dependencies and project configuration |
| `testng.xml`                           | TestNG suite configuration                   |
| `test-output/`                         | Test execution reports                       |

---

## 🧹 Clean Test Results

To remove previous Maven build and test output before execution:

```bash
mvn clean
```

To clean and execute the tests:

```bash
mvn clean test
```
