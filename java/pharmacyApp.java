
import java.util.Scanner;

public class pharmacyApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   PHARMACY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Medicine Management");
            System.out.println("2. Supplier Management");
            System.out.println("3. Purchase Management");
            System.out.println("4. Inventory Management");
            System.out.println("5. Medicine Sales");
            System.out.println("6. Expiry Management");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number (1-7): ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    MedicineManagement.main(new String[]{});
                    break;

                case 2:
                    SupplierManagement.main(new String[]{});
                    break;

                case 3:
                    PurchaseManagement.main(new String[]{});
                    break;

                case 4:
                    InventoryManagement.main(new String[]{});
                    break;

                case 5:
                    SalesManagement.main(new String[]{});
                    break;

                case 6:
                    ExpiryManagement.main(new String[]{});
                    break;

                case 7:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 7.");
            }

        } while (choice != 7);

        sc.close();
    }
}
