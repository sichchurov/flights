package com.gridnine.testing;

public class TimeBeforeArrival {

    private final int hours;

    public TimeBeforeArrival(int hours) {
        this.hours = hours;
    }

    boolean isFlights(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (Math.abs(segment.getArrivalDate().getHour() - segment.getDepartureDate().getHour()) > hours) {
                return false;
            }
        }
        return true;
    }
}
