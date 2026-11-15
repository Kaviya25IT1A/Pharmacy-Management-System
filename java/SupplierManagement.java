
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SupplierManagement {

    static Scanner sc = new Scanner(System.in);

    public static void addSupplier() {

        System.out.print("Enter Supplier Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Contact Person: ");
        String contact = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        String sql = "INSERT INTO public.suppliers " +
            "(supplier_name, contact_person, phone, email, address) " +
            "VALUES (?, ?, ?, ?, ?)";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, name);
            ps.setString(2, contact);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);

            ps.executeUpdate();

            System.out.println("Supplier Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error adding supplier!");
            e.printStackTrace();
        }
    }

    public static void viewSuppliers() {

        String sql = "SELECT * FROM public.suppliers ORDER BY supplier_id";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("\n========== SUPPLIER LIST ==========");

            while (rs.next()) {
                System.out.println("Supplier ID: " + rs.getInt("supplier_id"));
                System.out.println("Name: " + rs.getString("supplier_name"));
                System.out.println("Contact: " + rs.getString("contact_person"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error viewing suppliers!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("1. Add Supplier");
        System.out.println("2. View Suppliers");
        System.out.println("3. Exit");

        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            addSupplier();
        } else if (choice == 2) {
            viewSuppliers();
        } else {
            System.out.println("Thank you!");
        }
    }
}
