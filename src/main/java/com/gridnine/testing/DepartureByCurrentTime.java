package com.gridnine.testing;

import java.time.LocalDateTime;

public class DepartureByCurrentTime {
    private final LocalDateTime dateTime;

    public DepartureByCurrentTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    boolean isFlights(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(dateTime)) {
                return false;
            }
        }
        return true;
    }
}
