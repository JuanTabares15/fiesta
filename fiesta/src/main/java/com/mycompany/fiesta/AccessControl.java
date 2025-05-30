package com.mycompany.fiesta;

import java.util.HashSet;

public class AccessControl {
    private HashSet<String> attendees;

    public AccessControl() {
        attendees = new HashSet<>();
    }

    public void registerAttendee(String attendeeName) {
        attendees.add(attendeeName);
    }

    public int getTotalAttendees() {
        return attendees.size();
    }

    public HashSet<String> getAttendees() {
        return attendees;
    }

    @Override
    public String toString() {
        return "AccessControl [Total Attendees=" + attendees.size() + ", List=" + attendees + "]";
    }
}

