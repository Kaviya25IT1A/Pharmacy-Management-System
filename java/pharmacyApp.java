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
                case 1 -> System.out.println("Medicine Management - module coming next.");
                case 2 -> System.out.println("Supplier Management - module coming next.");
                case 3 -> System.out.println("Purchase Management - module coming next.");
                case 4 -> System.out.println("Inventory Management - module coming next.");
                case 5 -> System.out.println("Medicine Sales - module coming next.");
                case 6 -> System.out.println("Expiry Management - module coming next.");
                case 7 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice. Please select 1 to 7.");
            }
        } while (choice != 7);

        sc.close();
    }
}
