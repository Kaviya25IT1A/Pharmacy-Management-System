# Pharmacy Stock Management and Medicine Sales Analysis System

## 1. Project Overview

The Pharmacy Stock Management and Medicine Sales Analysis System is a software application developed to manage pharmacy operations efficiently.

It helps manage medicines, suppliers, purchases, inventory, expiry dates, and medicine sales. It also analyzes sales data using Python.

## 2. Technologies Used

- Java
- PostgreSQL
- JDBC
- Python
- Pandas
- NumPy
- Matplotlib
- Git and GitHub

## 3. Project Modules

1. Medicine Management
2. Supplier Management
3. Purchase Management
4. Inventory Management
5. Expiry Management
6. Sales Management
7. Sales Data Analysis

## 4. Project Structure

```text
Pharmacy-Management-System/
│
├── database/
│
├── docs/
│   ├── Abstract.md
│   ├── SRS.md
│   ├── System_Architecture.md
│   ├── Use_Case_Diagram.md
│   ├── Class_Diagram.md
│   ├── Database_ER_Diagram.md
│   ├── Testing_Report.md
│   └── Risk_Analysis.md
│
├── java/
│   ├── pharmacyApp.java
│   ├── DatabaseConnection.java
│   ├── MedicineManagement.java
│   ├── SupplierManagement.java
│   ├── PurchaseManagement.java
│   ├── InventoryManagement.java
│   ├── ExpiryManagement.java
│   ├── SalesManagement.java
│   └── lib/
│
├── python/
│   ├── db_connection.py
│   ├── test_connection.py
│   └── sales_analysis.py
│
├── outputs/
│   └── sales_analysis.png
│
└── README.md
```

## 5. Database Configuration

Database: PostgreSQL

Database name: `pharmacy_db`

Host: `localhost`

Port: `5432`

The Java application uses JDBC to connect to PostgreSQL.

Configure your PostgreSQL password locally before running the application. Do not upload database passwords to GitHub.

## 6. How to Run the Java Application

Open PowerShell and navigate to the Java folder:

```powershell
cd Pharmacy-Management-System\java
```

Set your PostgreSQL password:

```powershell
$env:DB_PASSWORD="YOUR_POSTGRESQL_PASSWORD"
```

Compile the application:

```powershell
javac -cp "lib\*" *.java
```

Run the main application:

```powershell
java -cp ".;lib\*" pharmacyApp
```

## 7. How to Run Python Sales Analysis

Navigate to the Python folder:

```powershell
cd Pharmacy-Management-System\python
```

Run the analysis:

```powershell
py sales_analysis.py
```

The program retrieves sales data from PostgreSQL, calculates sales statistics, and generates a chart in the outputs folder.

## 8. Documentation

Project documentation is available in the `docs/` folder. It includes the abstract, Software Requirements Specification, system architecture, diagrams, testing report, and risk analysis.

## 9. Project Objective

The main objective is to reduce manual pharmacy work, improve stock tracking, manage medicine expiry dates, record sales, and analyze sales performance.

## 10. Future Enhancements

- User login and authentication
- Billing and invoice generation
- Automated low-stock alerts
- Advanced sales reports
- Graphical user interface

## 11. Conclusion

This project demonstrates the use of Java programming, PostgreSQL database management, JDBC connectivity, Python data analysis, and software engineering concepts in a practical pharmacy management application.