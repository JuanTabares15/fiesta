package com.mycompany.fiesta;

public class Event {
    private String name;
    private String date;
    private String time;
    private String location;
    private String category;

    private int ticketsSold = 0;
    private int ticketLimit;  

    public Event(String name, String date, String time, String location, String category, int ticketLimit) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.category = category;
        this.ticketLimit = ticketLimit;
    }

    // Getters y setters 
    public String getName() { return name; }
    public int getTicketsSold() { return ticketsSold; }
    public int getTicketLimit() { return ticketLimit; }
    public int getTicketsAvailable() { return ticketLimit - ticketsSold; }

    public boolean canSellTickets(int quantity) {
        return (ticketsSold + quantity) <= ticketLimit;
    }

    public void sellTickets(int quantity) {
        if (canSellTickets(quantity)) {
            ticketsSold += quantity;
        }
    }

    @Override
    public String toString() {
        return "Event [Name=" + name + ", Date=" + date + ", Time=" + time +
               ", Location=" + location + ", Category=" + category + ", Tickets Sold=" +
               ticketsSold + "/" + ticketLimit + "]";
    }
}








