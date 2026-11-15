
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InventoryManagement {

    static Scanner sc = new Scanner(System.in);

    // VIEW ALL MEDICINE STOCK
    public static void viewInventory() {

        String sql = "SELECT medicine_id, medicine_name, quantity " +
                     "FROM public.medicines ORDER BY medicine_id";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== INVENTORY LIST ==========");

            while (rs.next()) {
                System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
                System.out.println("Medicine Name: " + rs.getString("medicine_name"));
                System.out.println("Available Quantity: " + rs.getInt("quantity"));
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error viewing inventory!");
            e.printStackTrace();
        }
    }

    // VIEW LOW STOCK MEDICINES
    public static void viewLowStock() {

        String sql = "SELECT medicine_id, medicine_name, quantity " +
                     "FROM public.medicines WHERE quantity <= 10 " +
                     "ORDER BY quantity";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== LOW STOCK MEDICINES ==========");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
                System.out.println("Medicine Name: " + rs.getString("medicine_name"));
                System.out.println("Available Quantity: " + rs.getInt("quantity"));
                System.out.println("--------------------------------");
            }

            if (!found) {
                System.out.println("No low-stock medicines found.");
            }

        } catch (Exception e) {
            System.out.println("Error checking low stock!");
            e.printStackTrace();
        }
    }

    // VIEW TOTAL STOCK
    public static void viewTotalStock() {

        String sql = "SELECT SUM(quantity) AS total_stock " +
                     "FROM public.medicines";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                System.out.println("\nTotal Medicine Stock: " +
                                   rs.getInt("total_stock"));
            }

        } catch (Exception e) {
            System.out.println("Error calculating total stock!");
            e.printStackTrace();
        }
    }

    // MAIN MENU
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== INVENTORY MANAGEMENT ==========");
            System.out.println("1. View All Inventory");
            System.out.println("2. View Low Stock Medicines");
            System.out.println("3. View Total Stock");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    viewInventory();
                    break;

                case 2:
                    viewLowStock();
                    break;

                case 3:
                    viewTotalStock();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}
