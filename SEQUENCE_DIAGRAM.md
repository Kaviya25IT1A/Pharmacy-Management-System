# SEQUENCE DIAGRAM

## 1. Introduction

The Sequence Diagram illustrates the chronological interaction between the Staff, Frontend, Java Backend API, JDBC, and PostgreSQL database while recording a medicine sale.

## 2. Sequence Diagram

```mermaid
sequenceDiagram
    actor Staff
    participant UI as Frontend (Web UI)
    participant API as Java Backend API
    participant JDBC
    participant DB as PostgreSQL Database

    Staff->>UI: Select medicine and enter quantity
    UI->>API: POST /api/sales
    API->>JDBC: Begin transaction and check stock
    JDBC->>DB: SELECT stock (FOR UPDATE)
    DB-->>JDBC: Return available quantity
    JDBC-->>API: Stock information

    alt Stock is sufficient
        API->>JDBC: Insert sale and deduct stock
        JDBC->>DB: INSERT sale; UPDATE medicine quantity
        DB-->>JDBC: Operation successful
        JDBC-->>API: Success result
        API->>JDBC: Commit transaction
        API-->>UI: JSON success response
        UI-->>Staff: Display sale success
    else Stock is insufficient
        API-->>UI: JSON error response
        UI-->>Staff: Display insufficient-stock message
        API->>JDBC: Rollback transaction (if transaction started)
    end
```

## 3. Participants

| Participant | Description |
|---|---|
| Staff | Initiates a medicine sale through the website. |
| Frontend (Web UI) | Collects the medicine and quantity and sends the API request. |
| Java Backend API | Validates the request, checks stock, and manages the sale process. |
| JDBC | Executes SQL statements and returns database results to Java. |
| PostgreSQL Database | Stores the sale and updates the medicine stock quantity. |

## 4. Sequence of Messages

1. Staff selects a medicine and enters the quantity.
2. Frontend sends a `POST /api/sales` request to the Java backend.
3. Backend starts the sale transaction and requests stock information through JDBC.
4. PostgreSQL returns the available stock.
5. If stock is sufficient, the backend inserts the sale record and deducts the quantity.
6. The transaction is committed when successful; an error causes rollback.
7. Backend sends a JSON response and frontend displays the result to Staff.

## 5. Conclusion

The Sequence Diagram shows the order of communication between system participants during a medicine sale, including stock validation, database operations, and the response shown to the staff member.
