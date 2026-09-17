import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Supplier> supplierList = new ArrayList<>();
    private ArrayList<StockTransaction> transactionList = new ArrayList<>();

    public void addSupplier(Supplier s) {
        supplierList.add(s);
    }

    public Supplier findSupplier(String id) {
        for (int i = 0; i < supplierList.size(); i++) {
            if (supplierList.get(i).getSupplierId().equalsIgnoreCase(id)) {
                return supplierList.get(i);
            }
        }
        return null;
    }

    public void showSuppliers() {
        if (supplierList.isEmpty()) {
            System.out.println("No suppliers found.");
            return;
        }
        for (int i = 0; i < supplierList.size(); i++) {
            supplierList.get(i).displaySupplier();
        }
    }

    public void addItem(Item item) {
        itemList.add(item);
        transactionList.add(new StockTransaction(item.getId(), "RESTOCK", item.getQuantity(), "Initial Inventory"));
    }

    public Item findItem(String id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equalsIgnoreCase(id)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public void showAllItems() {
        if (itemList.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).displayItem();
        }
    }

    public boolean restockItem(String itemId, int amount, String note) {
        Item item = findItem(itemId);
        if (item == null || amount <= 0) {
            return false;
        }
        item.addStock(amount);
        transactionList.add(new StockTransaction(itemId, "RESTOCK", amount, note));
        return true;
    }

    public boolean dispatchItem(String itemId, int amount, String note) {
        Item item = findItem(itemId);
        if (item == null || amount <= 0) {
            return false;
        }
        boolean success = item.reduceStock(amount);
        if (success) {
            transactionList.add(new StockTransaction(itemId, "DISPATCH", amount, note));
            return true;
        }
        return false;
    }

    public void showLowStockAlerts() {
        System.out.println("\n--- Low Stock Alerts ---");
        boolean hasAlerts = false;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (item.isLowStock()) {
                System.out.println("ALERT: " + item.getName() + " is low! Current: " + item.getQuantity() + " (Threshold: " + item.getLowStockThreshold() + ")");
                hasAlerts = true;
            }
        }
        if (!hasAlerts) {
            System.out.println("All items are well stocked.");
        }
    }

    public void showRestockHistory() {
        System.out.println("\n--- Stock Movement History ---");
        if (transactionList.isEmpty()) {
            System.out.println("No movement logged yet.");
            return;
        }
        for (int i = 0; i < transactionList.size(); i++) {
            transactionList.get(i).displayTransaction();
        }
    }

    public void showTotalValuation() {
        double total = 0.0;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            total = total + (item.getQuantity() * item.getPrice());
        }
        System.out.println("Total Inventory Asset Value: $" + total);
    }
}
