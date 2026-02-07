# Ecommerce-Test-Automation-Framework
This repository contains a Selenium automation framework built using Java, TestNG, Maven, and Page Object Model (POM). It automates core E-commerce functionalities such as Home Page validation, Login, Registration, and Product Search with detailed Extent Reports and screenshots.
# Ecommerce Selenium Automation Framework
## 📌 Overview
This project is a Selenium automation framework developed to test an E-commerce web application.
It follows the Page Object Model (POM) design pattern and uses TestNG for test execution.
- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- Page Object Model (POM)

## Project Structure
src/test/java
│
├── pages
│ ├── HomePage.java
│ ├── LoginPage.java
│ ├── RegistrationPage.java
│ └── SearchPage.java
│
├── testcases
│ ├── HomePageTest.java
│ ├── LoginTest.java
│ ├── RegistrationTest.java
│ └── SearchPageTest.java
│
├── utilities
│ ├── BaseTest.java
│ ├── DriverSetup.java
│ ├── ExtentManager.java
│ ├── Screenshots.java
│ └── TestListener.java
## Features
- Page Object Model design
- Cross-browser support (Chrome)
- TestNG test execution
- Extent HTML reports
- Screenshot capture on failure
- Maven dependency management

## How to Run
1. Clone the repository
2. Import as a Maven project
3. Run `testng.xml`
4. View reports in `ExtentReports/TestReport.html`
## Reports
- Extent HTML Reports
- Screenshots for failed test cases

## Author
Ravindra Kumar Dandasi
