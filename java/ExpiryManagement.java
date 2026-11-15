
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ExpiryManagement {

    static Scanner sc = new Scanner(System.in);

    // VIEW ALL MEDICINES WITH EXPIRY DATES
    public static void viewAllExpiry() {

        String sql = "SELECT medicine_id, medicine_name, expiry_date " +
                     "FROM public.medicines ORDER BY expiry_date";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== MEDICINE EXPIRY LIST ==========");

            while (rs.next()) {
                System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
                System.out.println("Medicine Name: " + rs.getString("medicine_name"));
                System.out.println("Expiry Date: " + rs.getDate("expiry_date"));
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error viewing expiry list!");
            e.printStackTrace();
        }
    }

    // VIEW EXPIRED MEDICINES
    public static void viewExpiredMedicines() {

        String sql = "SELECT medicine_id, medicine_name, expiry_date " +
                     "FROM public.medicines WHERE expiry_date < CURRENT_DATE " +
                     "ORDER BY expiry_date";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== EXPIRED MEDICINES ==========");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
                System.out.println("Medicine Name: " + rs.getString("medicine_name"));
                System.out.println("Expiry Date: " + rs.getDate("expiry_date"));
                System.out.println("--------------------------------");
            }

            if (!found) {
                System.out.println("No expired medicines found.");
            }

        } catch (Exception e) {
            System.out.println("Error checking expired medicines!");
            e.printStackTrace();
        }
    }

    // VIEW MEDICINES EXPIRING WITHIN 30 DAYS
    public static void viewUpcomingExpiry() {

        String sql = "SELECT medicine_id, medicine_name, expiry_date " +
                     "FROM public.medicines " +
                     "WHERE expiry_date >= CURRENT_DATE " +
                     "AND expiry_date <= CURRENT_DATE + 30 " +
                     "ORDER BY expiry_date";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== UPCOMING EXPIRY MEDICINES ==========");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
                System.out.println("Medicine Name: " + rs.getString("medicine_name"));
                System.out.println("Expiry Date: " + rs.getDate("expiry_date"));
                System.out.println("--------------------------------");
            }

            if (!found) {
                System.out.println("No medicines expiring within 30 days.");
            }

        } catch (Exception e) {
            System.out.println("Error checking upcoming expiry!");
            e.printStackTrace();
        }
    }

    // MAIN MENU
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== EXPIRY MANAGEMENT ==========");
            System.out.println("1. View All Expiry Dates");
            System.out.println("2. View Expired Medicines");
            System.out.println("3. View Medicines Expiring Within 30 Days");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    viewAllExpiry();
                    break;

                case 2:
                    viewExpiredMedicines();
                    break;

                case 3:
                    viewUpcomingExpiry();
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
