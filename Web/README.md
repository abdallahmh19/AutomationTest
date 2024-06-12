# Automation Assignment

This repository contains automated test frameworks for frontend and API assignments.

## Frontend Assignment
- Framework: Selenium WebDriver with Java and TestNG
- Task: Validate subscription packages on the provided URL for different countries.

## API Assignment
- Framework: Rest Assured with Java and TestNG
- Task: Automate adding a new device using the provided API endpoint and validate the response.

### Setup Instructions
1. Clone this repository to your local machine.
2. Ensure all prerequisites are installed.
3. Open the project in your preferred IDE.
4. Run the tests:
   - For Frontend: Run the FrontendTest.java class as a TestNG test.
   - For API: Run the APITest.java class as a TestNG test.

### Project Structure

- framework
  - Web
    - src
      - main
      - test
        - java
          - tests
            - NewDevice.java
            - Subscription.java
        - recources
            - test.xml
    - pom.xml
  - README.md