/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private int daysWorked;
    private double dailyRate;

    // Constructor
    public Employee(String employeeId, String name, String department, int daysWorked, double dailyRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.daysWorked = daysWorked;
        this.dailyRate = dailyRate;
    }

    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getDaysWorked() { return daysWorked; }
    public void setDaysWorked(int daysWorked) { this.daysWorked = daysWorked; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    // Business Logic Methods
    public double calculateRegularPay() {
        int regularDays = Math.min(daysWorked, 22);
        return regularDays * dailyRate;
    }

    public double calculateOvertimePay() {
        if (daysWorked > 22) {
            int overtimeDays = daysWorked - 22;
            double overtimeRate = dailyRate * 1.25;
            return overtimeDays * overtimeRate;
        }
        return 0.0;
    }

    public double calculateGrossPay() {
        return calculateRegularPay() + calculateOvertimePay();
    }

    public double calculateDeduction() {
        double grossPay = calculateGrossPay();
        if (grossPay <= 15000) {
            return grossPay * 0.05;
        } else {
            return grossPay * 0.08;
        }
    }

    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeduction();
    }

    public String getAttendanceClassification() {
        if (daysWorked < 15) {
            return "Poor Attendance";
        } else if (daysWorked <= 21) {
            return "Incomplete Attendance";
        } else if (daysWorked == 22) {
            return "Complete Attendance";
        } else {
            return "Overtime Worker";
        }
    }

    public void displayPayroll() {
        System.out.println("===== EMPLOYEE PAYROLL =====");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Days Worked: " + daysWorked);
        System.out.printf("Daily Rate: ₱%.2f%n", dailyRate);
        System.out.printf("Regular Pay: ₱%.2f%n", calculateRegularPay());
        System.out.printf("Overtime Pay: ₱%.2f%n", calculateOvertimePay());
        System.out.printf("Gross Pay: ₱%.2f%n", calculateGrossPay());
        System.out.printf("Deduction: ₱%.2f%n", calculateDeduction());
        System.out.printf("Net Pay: ₱%.2f%n", calculateNetPay());
        System.out.println("Classification: " + getAttendanceClassification());
        System.out.println();
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("EMP-001", "Maria Cruz", "IT", 25, 700.00);
        emp1.displayPayroll();
    }
}