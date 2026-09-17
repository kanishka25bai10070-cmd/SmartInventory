public class Item {
    private String id;
    private String name;
    private int quantity;
    private int lowStockThreshold;
    private double price;
    private Supplier supplier;

    public Item(String id, String name, int quantity, int lowStockThreshold, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.lowStockThreshold = lowStockThreshold;
        this.price = price;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLowStockThreshold() {
        return lowStockThreshold;
    }

    public double getPrice() {
        return price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void addStock(int amount) {
        this.quantity = this.quantity + amount;
    }

    public boolean reduceStock(int amount) {
        if (amount > this.quantity) {
            return false;
        }
        this.quantity = this.quantity - amount;
        return true;
    }

    public boolean isLowStock() {
        return this.quantity <= this.lowStockThreshold;
    }

    public void displayItem() {
        String supplierName = (supplier != null) ? supplier.getName() : "None";
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Stock: " + quantity +
                " | Min Threshold: " + lowStockThreshold +
                " | Price: $" + price +
                " | Supplier: " + supplierName);
    }
}
