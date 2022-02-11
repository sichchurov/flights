package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final int LAND_TIME = 2;

    public static void main(String[] args) {

        System.out.println("\nFlights without filters");
        List<Flight> allFlights = FlightBuilder.createFlights();
        allFlights.forEach(System.out::println);

        ArrivalBeforeDeparture arrivalBeforeDeparture = new ArrivalBeforeDeparture();
        System.out.println("\nAll flights with arrival date before departure are been excluded");
        List<Flight> arrivalBeforeDepartureListFiltered = allFlights.stream()
                .filter(arrivalBeforeDeparture::isFlights)
                .collect(Collectors.toList());
        arrivalBeforeDepartureListFiltered.forEach(System.out::println);

        DepartureByCurrentTime departureByCurrentTime = new DepartureByCurrentTime(LocalDateTime.now());
        System.out.println("\nAll departures by that time are been excluded");
        List<Flight> departureByCurrentTimeListFiltered = allFlights.stream()
                .filter(departureByCurrentTime::isFlights)
                .collect(Collectors.toList());
        departureByCurrentTimeListFiltered.forEach(System.out::println);

        TimeBeforeArrival timeBeforeArrival = new TimeBeforeArrival(LAND_TIME);
        System.out.println("\nNo more than two hours on the land");
        List<Flight> timeOnTheLandListFiltered = allFlights.stream()
                .filter(timeBeforeArrival::isFlights)
                .collect(Collectors.toList());
        timeOnTheLandListFiltered.forEach(System.out::println);

        System.out.println("\nFlights with all filters");
        List<Flight> allFiltered = allFlights.stream()
                .filter(arrivalBeforeDeparture::isFlights)
                .filter(departureByCurrentTime::isFlights)
                .filter(timeBeforeArrival::isFlights)
                .collect(Collectors.toList());
        allFiltered.forEach(System.out::println);
    }
}
