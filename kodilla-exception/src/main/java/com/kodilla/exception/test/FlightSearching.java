package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearching {
    public static boolean findFlight(Flight flight) throws RouteNotFoundException {
        // Imitating data
        Map<String, Boolean> flights = new HashMap<>();
        flights.put("Warsaw", true);
        flights.put("Milan", false);
        flights.put("London", true);

        try {
            return flights.get(flight.getArrivalAirport());
        } catch (NullPointerException e) {
            throw new RouteNotFoundException("404: Route to " + flight.getArrivalAirport() + " NOT FOUND!");
        }
    }

    public static void main(String[] args) {
        Flight liverpoolToRome = new Flight("Liverpool", "Rome");

        try {
            boolean isTravelToRomePossible = FlightSearching.findFlight(liverpoolToRome);
            if(isTravelToRomePossible) System.out.println("Travel to Rome is possible");
            else System.out.println("Travel to Rome is NOT possible");
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Welcome to " + liverpoolToRome.getDepartureAirport() + " Airport. Thank you for using our services.");
        }
    }
}
