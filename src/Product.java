public class Product {
    private double productCost;
    private int quantity;
    private String productName;

    // Constructor
    public Product(String name, double cost, int qty) {
        this.productName = name;
        this.productCost = cost;
        this.quantity = qty;
    }

    // Method to calculate total cost
    public void totalCost() {
        double total = productCost * quantity;
        System.out.println("Total cost for " + quantity + " " + productName + "(s): $" + total);
    }

    // Method to print product details
    public void printProduct() {
        System.out.println("Product: " + productName);
        System.out.println("Cost per unit: $" + productCost);
        System.out.println("Quantity purchased: " + quantity);
    }
}
