
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from db_connection import get_connection

connection = get_connection()

if connection:
    query = """
    SELECT
        m.medicine_name AS "Medicine",
        SUM(s.quantity) AS "Quantity_Sold",
        s.selling_price AS "Price",
        SUM(s.total_amount) AS "Total_Sales"
    FROM public.sales s
    JOIN public.medicines m
    ON s.medicine_id = m.medicine_id
    GROUP BY m.medicine_name, s.selling_price
    ORDER BY m.medicine_name;
    """

    df = pd.read_sql_query(query, connection)
    connection.close()

    print("\n========== PHARMACY SALES ANALYSIS ==========")

    if not df.empty:
        print("\nActual Sales Data:")
        print(df)

        total_quantity = np.sum(df["Quantity_Sold"])
        print("\nTotal Quantity Sold:", total_quantity)

        total_revenue = np.sum(df["Total_Sales"])
        print("Total Revenue: Rs.", total_revenue)

        average_sales = np.mean(df["Total_Sales"])
        print("Average Sales: Rs.", average_sales)

        highest = df.loc[df["Total_Sales"].idxmax()]

        print("\nHighest Selling Medicine:", highest["Medicine"])
        print("Sales Amount: Rs.", highest["Total_Sales"])

        plt.figure(figsize=(8, 5))
        plt.bar(df["Medicine"], df["Total_Sales"])

        plt.title("Pharmacy Medicine Sales Analysis")
        plt.xlabel("Medicine Name")
        plt.ylabel("Total Sales (Rs.)")

        plt.xticks(rotation=20)
        plt.tight_layout()

        plt.savefig("../outputs/sales_analysis.png")
        plt.show()

    else:
        print("No sales records found in the database.")
