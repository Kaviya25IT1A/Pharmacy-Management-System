
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesManagement {

    static Scanner sc = new Scanner(System.in);

    // ADD MEDICINE SALE AND REDUCE STOCK
    public static void addSale() {

        System.out.print("Enter Medicine ID: ");
        int medicineId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero!");
            return;
        }

        String priceSql =
            "SELECT unit_price, quantity FROM public.medicines " +
            "WHERE medicine_id = ?";

        String insertSql =
            "INSERT INTO public.sales " +
            "(medicine_id, quantity, selling_price, total_amount) " +
            "VALUES (?, ?, ?, ?)";

        String updateSql =
            "UPDATE public.medicines " +
            "SET quantity = quantity - ? " +
            "WHERE medicine_id = ? AND quantity >= ?";

        try (Connection con = DatabaseConnection.getConnection()) {

            con.setAutoCommit(false);

            try (
                PreparedStatement pricePs = con.prepareStatement(priceSql);
                PreparedStatement insertPs = con.prepareStatement(insertSql);
                PreparedStatement updatePs = con.prepareStatement(updateSql)
            ) {

                pricePs.setInt(1, medicineId);

                try (ResultSet rs = pricePs.executeQuery()) {

                    if (!rs.next()) {
                        throw new Exception("Medicine ID not found!");
                    }

                    double price = rs.getDouble("unit_price");
                    int availableStock = rs.getInt("quantity");

                    if (quantity > availableStock) {
                        throw new Exception("Insufficient stock! Available: "
                                            + availableStock);
                    }

                    double totalAmount = price * quantity;

                    insertPs.setInt(1, medicineId);
                    insertPs.setInt(2, quantity);
                    insertPs.setDouble(3, price);
                    insertPs.setDouble(4, totalAmount);

                    insertPs.executeUpdate();

                    updatePs.setInt(1, quantity);
                    updatePs.setInt(2, medicineId);
                    updatePs.setInt(3, quantity);

                    int rows = updatePs.executeUpdate();

                    if (rows == 0) {
                        throw new Exception("Stock update failed!");
                    }

                    con.commit();

                    System.out.println("\nSale Added Successfully!");
                    System.out.println("Selling Price: " + price);
                    System.out.println("Quantity Sold: " + quantity);
                    System.out.println("Total Amount: " + totalAmount);
                    System.out.println("Medicine Stock Updated Successfully!");
                }

            } catch (Exception e) {

                con.rollback();
                throw e;
            }

        } catch (Exception e) {

            System.out.println("Error adding sale!");
            System.out.println(e.getMessage());
        }
    }

    // VIEW ALL SALES
    public static void viewSales() {

        String sql =
            "SELECT s.sale_id, s.medicine_id, m.medicine_name, " +
            "s.quantity, s.selling_price, s.total_amount, s.sale_date " +
            "FROM public.sales s " +
            "JOIN public.medicines m ON s.medicine_id = m.medicine_id " +
            "ORDER BY s.sale_id";

        try (
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n========== SALES LIST ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("Sale ID: " + rs.getInt("sale_id"));
                System.out.println("Medicine: " + rs.getString("medicine_name"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Selling Price: " + rs.getDouble("selling_price"));
                System.out.println("Total Amount: " + rs.getDouble("total_amount"));
                System.out.println("Sale Date: " + rs.getTimestamp("sale_date"));

                System.out.println("--------------------------------");
            }

            if (!found) {
                System.out.println("No sales records found.");
            }

        } catch (Exception e) {

            System.out.println("Error viewing sales!");
            e.printStackTrace();
        }
    }

    // MAIN MENU
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== SALES MANAGEMENT ==========");
            System.out.println("1. Add Medicine Sale");
            System.out.println("2. View Sales");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addSale();
                    break;

                case 2:
                    viewSales();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }
}
