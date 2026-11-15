

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PurchaseManagement {

    static Scanner sc = new Scanner(System.in);

    // ADD PURCHASE AND UPDATE STOCK
    public static void addPurchase() {

        System.out.print("Enter Medicine ID: ");
        int medicineId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Supplier ID: ");
        int supplierId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Purchase Price: ");
        double price = Double.parseDouble(sc.nextLine());

        String sql = "INSERT INTO public.purchases " +
            "(medicine_id, supplier_id, quantity, purchase_price) " +
            "VALUES (?, ?, ?, ?)";

        String updateStock =
            "UPDATE public.medicines " +
            "SET quantity = quantity + ? " +
            "WHERE medicine_id = ?";

        try (Connection con = DatabaseConnection.getConnection()) {

            con.setAutoCommit(false);

            try (
                PreparedStatement ps = con.prepareStatement(sql);
                PreparedStatement stockPs = con.prepareStatement(updateStock)
            ) {

                ps.setInt(1, medicineId);
                ps.setInt(2, supplierId);
                ps.setInt(3, quantity);
                ps.setDouble(4, price);

                ps.executeUpdate();

                stockPs.setInt(1, quantity);
                stockPs.setInt(2, medicineId);

                int rows = stockPs.executeUpdate();

                if (rows == 0) {
                    throw new Exception("Medicine ID not found!");
                }

                con.commit();

                System.out.println("Purchase Added Successfully!");
                System.out.println("Medicine Stock Updated Successfully!");

            } catch (Exception e) {

                con.rollback();
                throw e;
            }

        } catch (Exception e) {

            System.out.println("Error adding purchase!");
            e.printStackTrace();
        }
    }

    // VIEW PURCHASES
    public static void viewPurchases() {

        String sql = "SELECT * FROM public.purchases ORDER BY purchase_id";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== PURCHASE LIST ==========");

            while (rs.next()) {

                System.out.println("Purchase ID: " + rs.getInt("purchase_id"));
                System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
                System.out.println("Supplier ID: " + rs.getInt("supplier_id"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getDouble("purchase_price"));
                System.out.println("Date: " + rs.getDate("purchase_date"));

                System.out.println("---------------------------");
            }

        } catch (Exception e) {

            System.out.println("Error viewing purchases!");
            e.printStackTrace();
        }
    }

    // MAIN MENU
    public static void main(String[] args) {

        System.out.println("\n========== PURCHASE MANAGEMENT ==========");
        System.out.println("1. Add Purchase");
        System.out.println("2. View Purchases");
        System.out.println("3. Exit");

        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {

            addPurchase();

        } else if (choice == 2) {

            viewPurchases();

        } else {

            System.out.println("Thank you!");
        }
    }
}
