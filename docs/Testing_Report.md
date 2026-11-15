# TESTING REPORT

## 1. Introduction

Testing was performed to verify that the Pharmacy Stock Management and Medicine Sales Analysis System works correctly. The Java application, PostgreSQL database connection, and Python sales analysis were tested.

## 2. Testing Environment

| Component | Technology |
|---|---|
| Operating System | Windows |
| Programming Language | Java |
| Database | PostgreSQL |
| Database Connectivity | JDBC |
| Data Analysis | Python |
| Libraries | Pandas, NumPy, Matplotlib |
| Database Tool | pgAdmin 4 |
| Code Editor | Visual Studio Code |

## 3. Module Testing

| Test ID | Module | Test Performed | Expected Result | Status |
|---|---|---|---|---|
| TC01 | Database | Connect Java to PostgreSQL | Successful connection | PASS |
| TC02 | Medicine | View medicines | Display medicine records | PASS |
| TC03 | Medicine | Add, update and delete medicines | Perform CRUD operations | PASS |
| TC04 | Supplier | Add and view suppliers | Save and display supplier records | PASS |
| TC05 | Purchase | Add and view purchases | Save purchase records and update stock | PASS |
| TC06 | Inventory | View all inventory | Display medicine quantities | PASS |
| TC07 | Inventory | Check low stock | Display low-stock medicines or a no-record message | PASS |
| TC08 | Inventory | Calculate total stock | Display total stock quantity | PASS |
| TC09 | Expiry | View expiry dates | Display medicine expiry dates | PASS |
| TC10 | Expiry | Check expired medicines | Identify expired medicines | PASS |
| TC11 | Expiry | Check upcoming expiry | Identify medicines expiring within 30 days | PASS |
| TC12 | Sales | Add a medicine sale | Save sale and reduce stock | PASS |
| TC13 | Sales | View sales | Display sales records | PASS |
| TC14 | Python | Connect Python to PostgreSQL | Successful connection | PASS |
| TC15 | Data Analysis | Analyze sales data | Calculate sales statistics | PASS |
| TC16 | Visualization | Generate sales chart | Create sales analysis chart | PASS |

## 4. Sample Test Results

### 4.1 Medicine Sale Test

- Medicine: Paracetamol
- Quantity sold: 5
- Selling price: Rs. 3.00
- Total amount: Rs. 15.00
- Result: Sale successfully recorded.
- Stock was reduced from 130 to 125.

### 4.2 Inventory Test

- Total medicine stock displayed: 650
- Low-stock medicines: None found during testing.
- Result: Passed.

### 4.3 Expiry Test

- Expired medicines: None found during testing.
- Medicines expiring within 30 days: None found during testing.
- Result: Passed.

### 4.4 Python Sales Analysis Test

- Total quantity sold: 5
- Total revenue: Rs. 15.00
- Average sales amount: Rs. 15.00
- Highest-selling medicine: Paracetamol
- Result: Sales analysis completed successfully.

## 5. Output Files

The Python analysis generates a sales chart at:

`outputs/sales_analysis.png`

## 6. Conclusion

The tested modules performed as expected during the project tests. Java successfully communicated with PostgreSQL, medicine sales updated inventory, and Python retrieved and analyzed sales data.

The system successfully demonstrated medicine management, supplier management, purchases, inventory tracking, expiry checking, sales management, and sales analysis.