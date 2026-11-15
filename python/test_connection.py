
from db_connection import get_connection

connection = get_connection()

if connection:
    print("Python and PostgreSQL are connected!")
    connection.close()
    print("Database connection closed.")
