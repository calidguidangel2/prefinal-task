/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;

    // Constructor
    public Product(String productId, String productName, String category, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Business Logic Methods
    public double calculateInventoryValue() {
        return price * quantity;
    }

    public String getStockStatus() {
        if (quantity == 0) {
            return "Out of Stock";
        } else if (quantity >= 1 && quantity <= 10) {
            return "Low Stock";
        } else if (quantity >= 11 && quantity <= 50) {
            return "Normal Stock";
        } else {
            return "High Stock";
        }
    }

    public void displayProductInfo() {
        System.out.println("===== PRODUCT INFORMATION =====");
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.printf("Price: ₱%.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Inventory Value: ₱%.2f%n", calculateInventoryValue());
        System.out.println("Stock Status: " + getStockStatus());
        System.out.println();
    }

    public static void main(String[] args) {
        Product p1 = new Product("P-1001", "Wireless Mouse", "Computer Accessories", 850.00, 25);
        p1.displayProductInfo();
    }
}