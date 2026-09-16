ParaBank Automation Framework
An automated test suite built for the ParaBank banking application using Java, Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern. The framework incorporates data-driven testing, Extent Reports for logging, and automated failure screenshot capture.

🚀 Tech Stack & Tools
Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

Design Pattern: Page Object Model (POM)

Reporting: ExtentReports

Utilities: Apache POI (for Excel data-driven testing)

📁 Project Structure
Plaintext
ParaBankAutomation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/              # Base setup, browser initialization, and teardown
│   │   │   ├── pages/             # Page Object classes (Login, Registration, Home, etc.)
│   │   │   ├── reports/           # Extent Report listener configuration
│   │   │   └── utils/             # Helper classes (ConfigReader, ExcelUtils)
│   │   └── resources/
│   │       └── .gitkeep
│   │
│   └── test/
│       ├── java/
│       │   └── tests/             # Test case classes (BankingWorkflow, LoginDataDriven)
│       └── resources/
│           └── config.properties  # Global configuration properties (URL, browser credentials)
│
├── .gitignore
├── pom.xml                        # Maven dependencies and build plugins
└── testng.xml                     # TestNG suite configuration file
⚙️ Key Features
Page Object Model (POM): Ensures clean separation between test scripts and page locators for high maintainability.

Data-Driven Testing: Reads test data dynamically from external Excel spreadsheets using Apache POI.

Configurable Environment: Manages environments and properties seamlessly via config.properties.

Extent Reports Integration: Generates detailed, visually appealing HTML test reports complete with execution timestamps.

Automated Failure Screenshots: Automatically captures screenshots upon test failure for quick debugging.

🛠️ Prerequisites
Ensure you have the following installed on your local machine:

Java Development Kit (JDK)

Maven

Google Chrome (or your preferred browser) & matching ChromeDriver

🏃‍♂️ How to Run the Tests
Clone the Repository:

Bash
git clone [https://github.com/Archita0707/ParaBankAutomation.git](https://github.com/Archita0707/ParaBankAutomation.git)
Navigate to Project Directory:

Bash
cd ParaBankAutomation
Run Tests via Maven:
You can execute the entire test suite using the testng.xml file through Maven:

Bash
mvn clean test
📊 Reports
After test execution, generated Extent Reports can typically be located inside the target or designated report output directories to review pass/fail status and logs.
