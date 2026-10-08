/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ElectricityBill {
    private String accountNumber;
    private String customerName;
    private String customerType; 
    private int previousReading;
    private int currentReading;

    // Constructor
    public ElectricityBill(String accountNumber, String customerName, String customerType, int previousReading, int currentReading) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerType = customerType;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerType() { return customerType; }
    public void setCustomerType(String customerType) { this.customerType = customerType; }

    public int getPreviousReading() { return previousReading; }
    public void setPreviousReading(int previousReading) { this.previousReading = previousReading; }

    public int getCurrentReading() { return currentReading; }
    public void setCurrentReading(int currentReading) { this.currentReading = currentReading; }

////    
    public int calculateConsumption() {
        return currentReading - previousReading;
    }

    public double getRate() {
        int consumption = calculateConsumption();
        if (customerType.equalsIgnoreCase("Residential")) {
            if (consumption <= 100) return 10.0;
            else if (consumption <= 200) return 12.0;
            else return 15.0;
        } else if (customerType.equalsIgnoreCase("Commercial")) {
            if (consumption <= 100) return 15.0;
            else if (consumption <= 200) return 18.0;
            else return 22.0;
        }
        return 0.0;
    }

    public double calculateBill() {
        return calculateConsumption() * getRate();
    }

    public String getClassification() {
        int consumption = calculateConsumption();
        if (consumption < 100) {
            return "Low Consumption";
        } else if (consumption <= 200) {
            return "Moderate Consumption";
        } else {
            return "High Consumption";
        }
    }

    public void displayBill() {
        int consumption = calculateConsumption();
        System.out.println("===== ELECTRICITY BILL =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Type: " + customerType);
        System.out.println("Previous Reading: " + previousReading);
        System.out.println("Current Reading: " + currentReading);
        System.out.println("Consumption: " + consumption + " kWh");
        System.out.printf("Rate: ₱%.2f%n", getRate());
        System.out.printf("Total Bill: ₱%.2f%n", calculateBill());
        System.out.println("Classification: " + getClassification());
        
        if (consumption > 300) {
            System.out.println("WARNING: VERY HIGH ELECTRICITY CONSUMPTION");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ElectricityBill bill1 = new ElectricityBill("EL-1001", "Juan Santos", "Residential", 1250, 1475);
        ElectricityBill bill2 = new ElectricityBill("EL-1002", "Maria Clara", "Commercial", 2000, 2350);
        ElectricityBill bill3 = new ElectricityBill("EL-1003", "Pedro Penduko", "Residential", 500, 580);

        bill1.displayBill();
        bill2.displayBill();
        bill3.displayBill();
    }
}