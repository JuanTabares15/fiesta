package com.mycompany.fiesta;

import java.util.ArrayList;
import java.util.Scanner;

public class Fiesta {

    static ArrayList<Event> events = new ArrayList<>();
    static ArrayList<Location> locations = new ArrayList<>();
    static ArrayList<Artist> artists = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            do {
                System.out.println("\n=== EventMaster Pro Menu ===");
                System.out.println("1. Create Event");
                System.out.println("2. View Events");
                System.out.println("3. Create Location");
                System.out.println("4. View Locations");
                System.out.println("5. Create Artist");
                System.out.println("6. View Artists");
                System.out.println("7. Create Ticket");
                System.out.println("8. Exit");

                System.out.print("Select an option: ");
                option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                        createEvent(scanner);
                        break;
                    case 2:
                        viewEvents();
                        break;
                    case 3:
                        createLocation(scanner);
                        break;
                    case 4:
                        viewLocations();
                        break;
                    case 5:
                        createArtist(scanner);
                        break;
                    case 6:
                        viewArtists();
                        break;
                    case 7:
                        createTicket(scanner);
                        break;
                    case 8:
                        System.out.println("Exiting the system...");
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } while (option != 8);
        }
    }

    public static void createEvent(Scanner scanner) {
        System.out.print("Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Time (HH:MM): ");
        String time = scanner.nextLine();
        System.out.print("Location (Sur, Norte, Oriental, Occidental): ");
        String location = scanner.nextLine().trim();
        System.out.print("Category: ");
        String category = scanner.nextLine();

        
        int ticketLimit = getTicketLimitByLocation(location);

        Event event = new Event(name, date, time, location, category, ticketLimit);
        events.add(event);
        System.out.println("Event created successfully with ticket limit: " + ticketLimit);
        System.out.println("Total events: " + events.size());
    }

    
    public static int getTicketLimitByLocation(String location) {
        switch (location.toLowerCase()) {
            case "sur":
                return 5000;
            case "norte":
                return 5000;
            case "oriental":
                return 8000;
            case "occidental":
                return 6000;
            default:
                System.out.println("Location not recognized, default ticket limit set to 5000.");
                return 5000; 
        }
    }

    public static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events registered yet.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public static void createLocation(Scanner scanner) {
        System.out.print("Location Name: ");
        String name = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Technical Details: ");
        String technicalDetails = scanner.nextLine();

        Location location = new Location(name, capacity, technicalDetails);
        locations.add(location);
        System.out.println("Location created successfully!");
    }

    public static void viewLocations() {
        if (locations.isEmpty()) {
            System.out.println("No locations registered yet.");
        } else {
            for (Location location : locations) {
                System.out.println(location);
            }
        }
    }

    public static void createArtist(Scanner scanner) {
        System.out.print("Artist Name: ");
        String name = scanner.nextLine();
        System.out.print("Contact Info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Technical Requirements: ");
        String technicalRequirements = scanner.nextLine();

        Artist artist = new Artist(name, contactInfo, technicalRequirements);
        artists.add(artist);
        System.out.println("Artist created successfully!");
    }

    public static void viewArtists() {
        if (artists.isEmpty()) {
            System.out.println("No artists registered yet.");
        } else {
            for (Artist artist : artists) {
                System.out.println(artist);
            }
        }
    }

    public static void createTicket(Scanner scanner) {
        if (events.isEmpty()) {
            System.out.println("No events available. Please create an event first.");
            return;
        }

        System.out.println("Available Events:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println(i + ". " + events.get(i));
        }

        System.out.print("Select event index: ");
        int eventIndex = scanner.nextInt();
        scanner.nextLine(); 

        if (eventIndex < 0 || eventIndex >= events.size()) {
            System.out.println("Invalid event selection.");
            return;
        }

        Event selectedEvent = events.get(eventIndex);

        System.out.print("Buyer's Name: ");
        String buyerName = scanner.nextLine();

        System.out.print("Number of tickets to purchase: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        if (!selectedEvent.canSellTickets(quantity)) {
            System.out.println("Cannot purchase " + quantity + " tickets. Only " + selectedEvent.getTicketsAvailable() + " tickets remaining for this event.");
            return;
        }

        selectedEvent.sellTickets(quantity);
        Ticket ticket = new Ticket(buyerName, selectedEvent, quantity);
        tickets.add(ticket);

        System.out.println("Ticket(s) purchased successfully for " + selectedEvent.getName() + "! Total sold for this event: " + selectedEvent.getTicketsSold() + "/" + selectedEvent.getTicketLimit());
    }
}










