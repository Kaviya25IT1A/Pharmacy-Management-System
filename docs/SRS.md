# SOFTWARE REQUIREMENTS SPECIFICATION (SRS)

## 1. Introduction

### 1.1 Purpose
The purpose of this document is to describe the functional and non-functional requirements of the Pharmacy Stock Management and Medicine Sales Analysis System.

### 1.2 Project Scope
This system is designed to manage pharmacy activities, including medicine records, suppliers, purchases, inventory, expiry dates, and sales transactions. It also provides sales analysis and graphical reports using Python.

### 1.3 Intended Users
- Pharmacy administrators
- Pharmacists
- Pharmacy staff

## 2. Overall Description

### 2.1 Product Perspective
The system is a database-driven desktop application developed using Java, PostgreSQL, and Python.

### 2.2 Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| PostgreSQL | Database management |
| JDBC | Java database connectivity |
| Python | Sales data analysis |
| Pandas | Data processing |
| NumPy | Numerical calculations |
| Matplotlib | Graph generation |
| VS Code | Development environment |
| pgAdmin 4 | Database administration |

## 3. Functional Requirements

### 3.1 Medicine Management
- Add new medicine details.
- View available medicines.
- Update medicine information.
- Delete medicine records.

### 3.2 Supplier Management
- Add supplier details.
- View supplier information.

### 3.3 Purchase Management
- Record medicine purchases.
- Store purchase quantity and price.
- Automatically increase medicine stock when a purchase is recorded.
- View purchase records.

### 3.4 Inventory Management
- View all medicine stock.
- Identify low-stock medicines.
- Calculate total medicine stock.

### 3.5 Expiry Management
- View medicine expiry dates.
- Identify expired medicines.
- Identify medicines expiring within 30 days.

### 3.6 Sales Management
- Record medicine sales.
- Check available stock before selling.
- Automatically reduce stock after a successful sale.
- Calculate total sales amount.
- View sales records.

### 3.7 Sales Data Analysis
- Retrieve actual sales records from PostgreSQL.
- Calculate total quantity sold.
- Calculate total revenue.
- Calculate average sales.
- Identify the highest-selling medicine.
- Generate sales charts.

## 4. Non-Functional Requirements

### 4.1 Performance
The system should retrieve and process database records efficiently.

### 4.2 Reliability
The system should maintain accurate records and handle database errors.

### 4.3 Security
Database access should require valid PostgreSQL credentials.

### 4.4 Usability
The system should provide simple menu-driven operations.

### 4.5 Maintainability
The application should use separate Java classes for different management modules.

## 5. Hardware Requirements

- Computer or laptop
- Minimum 4 GB RAM
- Keyboard and mouse
- Sufficient storage space

## 6. Software Requirements

- Windows operating system
- Java Development Kit (JDK)
- Python
- PostgreSQL
- pgAdmin 4
- Visual Studio Code
- PostgreSQL JDBC Driver
- Required Python libraries: Pandas, NumPy, Matplotlib, and psycopg2-binary

## 7. Database Requirements

The system uses a PostgreSQL database named `pharmacy_db`.

Main database tables:

1. medicines
2. suppliers
3. purchases
4. sales

Primary keys and foreign keys are used to maintain relationships between database records.

## 8. Constraints

- PostgreSQL must be running for database operations.
- Valid database credentials are required.
- Medicine stock must not become negative.
- Purchase and sales quantities must be greater than zero.
- Python analysis requires access to the PostgreSQL database.

## 9. Conclusion

The Pharmacy Stock Management and Medicine Sales Analysis System provides an organized way to manage pharmacy operations. It combines Java programming, PostgreSQL database management, and Python data analysis to improve stock monitoring and sales reporting.