public class MainProduct {
    public static void main(String[] args) {
        // Create a Product object
        Product myProduct = new Product("Laptop", 800.00, 2);

        // Print product details
        myProduct.printProduct();

        // Print total cost
        myProduct.totalCost();
    }
}
