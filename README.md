# 🚀 Selenium BDD + Data-Driven Automation Framework

A robust and scalable **Test Automation Framework** built using **Selenium WebDriver with Java**,  
executed using **TestNG (Data-Driven approach)** and enhanced with **BDD dependencies (Cucumber)**  
to improve test readability and maintainability.

---

## 🧩 Tech Stack

- **Language:** Java  
- **UI Automation:** Selenium WebDriver  
- **Test Execution:** TestNG  
- **BDD Support:** Cucumber (Gherkin – Given/When/Then)  
- **Build Tool:** Maven  
- **CI/CD:** Jenkins  
- **Containerization:** Docker & Selenium Grid  
- **Version Control:** Git & GitHub  

---

## ✨ Key Highlights

- TestNG-based **Data-Driven Framework**
- BDD-style test scenarios using **Cucumber Feature files**
- Parallel execution using **Selenium Grid**
- Dockerized execution for consistency across environments
- CI/CD integration with **Jenkins**
- We can reduce execution time optimized from **~10 hours to 3–4 hours**
- Modular, reusable, and maintainable framework design

---

## 🧠 Framework Approach

- **TestNG** is used as the main test execution engine
- **Data-driven testing** is implemented using:
  - TestNG `@DataProvider`
  - Scenario Outline with Examples (BDD dependency)
- **Cucumber** is used for:
  - Writing readable test scenarios in Gherkin
  - Better collaboration between QA, Dev, and Business
- **BDD is used as a dependency**, not as the primary execution engine

---

▶️ How to Run

Test execution is centrally controlled via pom.xml using Maven Surefire.
The configured TestNG XML is picked automatically for all execution modes.

1️⃣ Local Execution
mvn clean test

2️⃣ Jenkins Pipeline with docker (Either manual execution or set up CRON job) (CI)

Jenkins pulls code from GitHub

Builds Docker image

Executes mvn clean test inside container

TestNG suite is picked from pom.xml

Reports archived in Jenkins

🔁 Change Test Suite

Update the suite reference in pom.xml:

<suiteXmlFile>testng.xml</suiteXmlFile>


No changes required in Jenkins, Dockerfile, or Docker Compose.


