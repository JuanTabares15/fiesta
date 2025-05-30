package com.mycompany.fiesta;

public class Location {
    private String name;
    private int capacity;
    private String technicalDetails;

    public Location(String name, int capacity, String technicalDetails) {
        this.name = name;
        this.capacity = capacity;
        this.technicalDetails = technicalDetails;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getTechnicalDetails() { return technicalDetails; }
    public void setTechnicalDetails(String technicalDetails) { this.technicalDetails = technicalDetails; }

    @Override
    public String toString() {
        return "Location [Name=" + name + ", Capacity=" + capacity + ", Technical Details=" + technicalDetails + "]";
    }
}

