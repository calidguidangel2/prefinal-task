/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
// Parent Class
class Room {
    protected String roomNumber;
    protected String roomType;
    protected String guestName;
    protected int numberOfNights;

    public Room(String roomNumber, String roomType, String guestName, int numberOfNights) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
    }

    public double calculateBookingCost() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Guest: " + guestName);
        System.out.println("Nights: " + numberOfNights);
        System.out.printf("Booking Cost: ₱%.2f%n", calculateBookingCost());
        System.out.println();
    }
}

// Subclasses
class StandardRoom extends Room {
    public StandardRoom(String roomNumber, String guestName, int numberOfNights) {
        super(roomNumber, "Standard", guestName, numberOfNights);
    }

    @Override
    public double calculateBookingCost() {
        return numberOfNights * 1500.0;
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomNumber, String guestName, int numberOfNights) {
        super(roomNumber, "Deluxe", guestName, numberOfNights);
    }

    @Override
    public double calculateBookingCost() {
        // Daily rate (2500) + Breakfast fee (300 per night)
        return (numberOfNights * 2500.0) + (numberOfNights * 300.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(String roomNumber, String guestName, int numberOfNights) {
        super(roomNumber, "Suite", guestName, numberOfNights);
    }

    @Override
    public double calculateBookingCost() {
        // Daily rate (4000 per night) + One-time Service fee (1000 per booking)
        return (numberOfNights * 4000.0) + 1000.0;
    }
}


public class HotelBookingSystem {
    public static void main(String[] args) {
        System.out.println("===== HOTEL BOOKING =====");

        // Array storing base class reference to demonstrate Polymorphism
        Room[] rooms = {
            new StandardRoom("101", "Pedro Cruz", 3),
            new DeluxeRoom("202", "Ana Reyes", 2),
            new SuiteRoom("301", "Carlo Santos", 2)
        };

        // Loop calling overridden methods dynamically at runtime
        for (Room room : rooms) {
            room.displayInfo();
        }
    }
}