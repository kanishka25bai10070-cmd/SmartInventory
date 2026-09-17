public class StockTransaction {
    private String itemId;
    private String type;
    private int quantity;
    private String note;

    public StockTransaction(String itemId, String type, int quantity, String note) {
        this.itemId = itemId;
        this.type = type;
        this.quantity = quantity;
        this.note = note;
    }

    public void displayTransaction() {
        System.out.println("Type: " + type +
                " | Item ID: " + itemId +
                " | Quantity: " + quantity +
                " | Note: " + note);
    }
}
