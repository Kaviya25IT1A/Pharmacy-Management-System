# PROJECT RISK ANALYSIS

## 1. Introduction

Risk analysis identifies possible problems that may affect the development and operation of the Pharmacy Stock Management and Medicine Sales Analysis System. It also describes preventive measures to reduce these risks.

## 2. Identified Risks

| Risk ID | Risk Description | Impact | Prevention |
|---|---|---|---|
| R01 | PostgreSQL database connection failure | High | Check database configuration and connection settings |
| R02 | Incorrect medicine stock quantity | High | Validate stock updates during purchases and sales |
| R03 | Duplicate medicine records | Medium | Check existing records before adding medicines |
| R04 | Incorrect medicine expiry information | High | Enter and verify expiry dates carefully |
| R05 | Invalid user input | Medium | Validate input values and handle exceptions |
| R06 | Python database connection failure | Medium | Verify database credentials and connection settings |
| R07 | Incorrect sales analysis | Medium | Validate database records and calculations |
| R08 | Accidental database deletion | High | Maintain regular database backups |
| R09 | Missing project files | Medium | Maintain a backup and use GitHub for version control |

## 3. Risk Management Strategies

### 3.1 Database Backup

Regularly back up the PostgreSQL database to prevent data loss.

### 3.2 Input Validation

Validate medicine prices, quantities, dates, and other user inputs before saving records.

### 3.3 Exception Handling

Use Java exception handling to manage database errors and unexpected input.

### 3.4 Transaction Management

Use database transactions for purchase and sales operations to maintain stock consistency.

### 3.5 Version Control

Use Git and GitHub to track project changes and maintain source-code backups.

## 4. Conclusion

Risk analysis helps identify possible problems before they affect the application. Proper validation, database backups, exception handling, and transaction management improve the reliability of the Pharmacy Management System.