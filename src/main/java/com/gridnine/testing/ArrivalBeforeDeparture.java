package com.gridnine.testing;

public class ArrivalBeforeDeparture {

    boolean isFlights(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return false;
            }
        }
        return true;
    }
}
