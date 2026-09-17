import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        Supplier sup1 = new Supplier("S1", "Apex Logistics", "apex@mail.com");
        Supplier sup2 = new Supplier("S2", "Tech Supplies", "tech@mail.com");
        manager.addSupplier(sup1);
        manager.addSupplier(sup2);

        manager.addItem(new Item("ITM1", "Mechanical Keyboard", 12, 5, 50.0, sup1));
        manager.addItem(new Item("ITM2", "USB Cable", 3, 5, 8.5, sup2));

        int choice = 0;
        while (choice != 7) {
            System.out.println("\n==================================");
            System.out.println("     INVENTORY & STOCK MANAGER    ");
            System.out.println("==================================");
            System.out.println("1. View All Items");
            System.out.println("2. Add New Item");
            System.out.println("3. Restock Item (Inward)");
            System.out.println("4. Dispatch / Sell Item (Outward)");
            System.out.println("5. View Low Stock Alerts");
            System.out.println("6. Reports (Valuation & History)");
            System.out.println("7. Exit");
            System.out.print("Enter choice (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\n--- Current Inventory ---");
                manager.showAllItems();
            } else if (choice == 2) {
                System.out.print("Enter Item ID (e.g. ITM3): ");
                String id = scanner.nextLine();
                System.out.print("Enter Item Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Initial Stock: ");
                int stock = scanner.nextInt();
                System.out.print("Enter Low Stock Threshold: ");
                int threshold = scanner.nextInt();
                System.out.print("Enter Price per unit: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Available Suppliers: ");
                manager.showSuppliers();
                System.out.print("Enter Supplier ID: ");
                String supId = scanner.nextLine();

                Supplier s = manager.findSupplier(supId);
                manager.addItem(new Item(id, name, stock, threshold, price, s));
                System.out.println("Item added successfully!");
            } else if (choice == 3) {
                System.out.print("Enter Item ID to restock: ");
                String id = scanner.nextLine();
                System.out.print("Enter Quantity to add: ");
                int qty = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Note / Batch reference: ");
                String note = scanner.nextLine();

                boolean ok = manager.restockItem(id, qty, note);
                if (ok) {
                    System.out.println("Restock successful.");
                } else {
                    System.out.println("Failed: Item not found or invalid quantity.");
                }
            } else if (choice == 4) {
                System.out.print("Enter Item ID to dispatch: ");
                String id = scanner.nextLine();
                System.out.print("Enter Quantity to dispatch: ");
                int qty = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Reason / Customer name: ");
                String note = scanner.nextLine();

                boolean ok = manager.dispatchItem(id, qty, note);
                if (ok) {
                    System.out.println("Dispatch successful.");
                } else {
                    System.out.println("Failed: Insufficient stock or item not found.");
                }
            } else if (choice == 5) {
                manager.showLowStockAlerts();
            } else if (choice == 6) {
                manager.showTotalValuation();
                manager.showRestockHistory();
            } else if (choice == 7) {
                System.out.println("Exiting system. Goodbye!");
            } else {
                System.out.println("Invalid option. Choose between 1 and 7.");
            }
        }
        scanner.close();
    }
}
