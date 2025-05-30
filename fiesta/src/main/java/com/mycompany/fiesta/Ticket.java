package com.mycompany.fiesta;

public class Ticket {
    private String buyerName;
    private Event event;
    private int quantity;

    public Ticket(String buyerName, Event event, int quantity) {
        this.buyerName = buyerName;
        this.event = event;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ticket [Buyer=" + buyerName + ", Event=" + event.getName() + ", Quantity=" + quantity + "]";
    }
}





