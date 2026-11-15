import psycopg2
import os

def get_connection():
    try:
        connection = psycopg2.connect(
            host="localhost",
            database="pharmacy_db",
            user="postgres",
            password=os.getenv("DB_PASSWORD"),
            port="5432"
        )

        print("PostgreSQL Database Connected Successfully!")
        return connection

    except Exception as e:
        print("Database Connection Failed:", e)
        return None