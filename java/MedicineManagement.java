
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class MedicineManagement {
static Scanner sc = new Scanner(System.in);
    public static void viewMedicines() {

        String sql = "SELECT * FROM public.medicines ORDER BY medicine_id";

        try (
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("\n========== MEDICINE LIST ==========");

            while (rs.next()) {

                System.out.println("Medicine ID: " +
                    rs.getInt("medicine_id"));

                System.out.println("Name: " +
                    rs.getString("medicine_name"));

                System.out.println("Category: " +
                    rs.getString("category"));

                System.out.println("Manufacturer: " +
                    rs.getString("manufacturer"));

                System.out.println("Price: " +
                    rs.getBigDecimal("unit_price"));

                System.out.println("Quantity: " +
                    rs.getInt("quantity"));

                System.out.println("Expiry Date: " +
                    rs.getDate("expiry_date"));

                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error displaying medicines!");
            e.printStackTrace();
        }
    }
public static void addMedicine() {

    
    System.out.println("\n========== ADD NEW MEDICINE ==========");

    System.out.print("Enter Medicine Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Category: ");
    String category = sc.nextLine();

    System.out.print("Enter Manufacturer: ");
    String manufacturer = sc.nextLine();

    System.out.print("Enter Unit Price: ");
    BigDecimal price = new BigDecimal(sc.nextLine());

    System.out.print("Enter Quantity: ");
    int quantity = Integer.parseInt(sc.nextLine());

    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
    Date expiryDate = Date.valueOf(sc.nextLine());

    String sql = "INSERT INTO public.medicines " +
            "(medicine_name, category, manufacturer, unit_price, quantity, expiry_date) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    try (
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)
    ) {

        pstmt.setString(1, name);
        pstmt.setString(2, category);
        pstmt.setString(3, manufacturer);
        pstmt.setBigDecimal(4, price);
        pstmt.setInt(5, quantity);
        pstmt.setDate(6, expiryDate);

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Medicine Added Successfully!");
        }

    } catch (Exception e) {
        System.out.println("Error adding medicine!");
        e.printStackTrace();
    }
}
public static void updateMedicine() {

    System.out.println("\n========== UPDATE MEDICINE ==========");

    System.out.print("Enter Medicine ID to update: ");
    int id = Integer.parseInt(sc.nextLine());

    System.out.print("Enter New Medicine Name: ");
    String name = sc.nextLine();

    System.out.print("Enter New Category: ");
    String category = sc.nextLine();

    System.out.print("Enter New Manufacturer: ");
    String manufacturer = sc.nextLine();

    System.out.print("Enter New Unit Price: ");
    BigDecimal price = new BigDecimal(sc.nextLine());

    System.out.print("Enter New Quantity: ");
    int quantity = Integer.parseInt(sc.nextLine());

    System.out.print("Enter New Expiry Date (YYYY-MM-DD): ");
    Date expiryDate = Date.valueOf(sc.nextLine());

    String sql = "UPDATE public.medicines SET " +
            "medicine_name = ?, category = ?, manufacturer = ?, " +
            "unit_price = ?, quantity = ?, expiry_date = ? " +
            "WHERE medicine_id = ?";

    try (
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)
    ) {

        pstmt.setString(1, name);
        pstmt.setString(2, category);
        pstmt.setString(3, manufacturer);
        pstmt.setBigDecimal(4, price);
        pstmt.setInt(5, quantity);
        pstmt.setDate(6, expiryDate);
        pstmt.setInt(7, id);

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Medicine Updated Successfully!");
        } else {
            System.out.println("Medicine ID Not Found!");
        }

    } catch (Exception e) {
        System.out.println("Error updating medicine!");
        e.printStackTrace();
    }
}
public static void deleteMedicine() {

    System.out.println("\n========== DELETE MEDICINE ==========");

    System.out.print("Enter Medicine ID to delete: ");
    int id = Integer.parseInt(sc.nextLine());

    String sql = "DELETE FROM public.medicines WHERE medicine_id = ?";

    try (
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)
    ) {

        pstmt.setInt(1, id);

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Medicine Deleted Successfully!");
        } else {
            System.out.println("Medicine ID Not Found!");
        }

    } catch (Exception e) {
        System.out.println("Error deleting medicine!");
        e.printStackTrace();
    }
}
public static void main(String[] args) {
    int choice;

    do {
        System.out.println("\n================================");
        System.out.println("   PHARMACY MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. View Medicines");
        System.out.println("2. Add Medicine");
        System.out.println("3. Update Medicine");
        System.out.println("4. Delete Medicine");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                viewMedicines();
                break;

            case 2:
                addMedicine();
                break;

           case 3:
                updateMedicine();
                break;
            case 4:
                deleteMedicine();
                 break;

            case 5:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 5 );
}
}