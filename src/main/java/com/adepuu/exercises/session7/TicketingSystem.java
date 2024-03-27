package com.adepuu.exercises.session7;

package com.adepuu.exercises.session7;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Interface defining methods for printing ticket details
interface Ticketable {
    void printTicketDetails();
}

// Ticket class representing a ticket for an event
class Ticket implements Ticketable {
    private static int totalTicketsSold = 0;
    private int ticketId;
    private String eventName;
    private double price;

    // Constructor to initialize ticket details
    public Ticket(int ticketId, String eventName, double price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.price = price;
        totalTicketsSold++;
    }

    // Getter methods
    public int getTicketId() {
        return ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }

    // Static method to get total tickets sold
    public static int getTotalTicketsSold() {
        return totalTicketsSold;
    }

    // Method to print ticket details
    @Override
    public void printTicketDetails() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Price: $" + price);
    }
}

public class TicketingSystem {
    public static void main(String[] args) {
        // Creating a map to store available tickets
        Map<Integer, Ticket> availableTickets = new HashMap<>();
        // Adding sample tickets
        availableTickets.put(1, new Ticket(1, "Concert", 50.0));
        availableTickets.put(2, new Ticket(2, "Movie", 20.0));
        availableTickets.put(3, new Ticket(3, "Theater", 30.0));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Displaying available tickets
            System.out.println("Available Tickets:");
            for (Map.Entry<Integer, Ticket> entry : availableTickets.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getEventName() + " - $" + entry.getValue().getPrice());
            }

            // Prompting user to select a ticket
            System.out.print("Select a ticket (Enter ticket number) or enter 0 to exit: ");
            int selectedTicketNumber = scanner.nextInt();

            if (selectedTicketNumber == 0) {
                System.out.println("Thank you for using the ticketing system. Exiting...");
                break;
            }

            // Checking if selected ticket is available
            Ticket selectedTicket = availableTickets.get(selectedTicketNumber);
            if (selectedTicket == null) {
                System.out.println("Invalid ticket number. Please select a valid ticket.");
                continue;
            }

            // Displaying selected ticket details
            System.out.println("Selected Ticket Details:");
            selectedTicket.printTicketDetails();

            // Confirming booking
            System.out.print("Confirm booking? (yes/no): ");
            String confirmation = scanner.next().toLowerCase();
            if (confirmation.equals("yes")) {
                System.out.println("Booking confirmed! Thank you for your purchase.");
                availableTickets.remove(selectedTicketNumber); // Removing booked ticket
            } else {
                System.out.println("Booking cancelled.");
            }
        }

        // Displaying total tickets sold
        System.out.println("Total tickets sold: " + Ticket.getTotalTicketsSold());
    }
}
