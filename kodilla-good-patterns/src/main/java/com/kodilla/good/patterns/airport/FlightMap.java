package com.kodilla.good.patterns.airport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlightMap {
    public static Map<City, Set<City>> create(Set<Flight> flights) {
        Map<City, Set<City>> flightMap = new HashMap<>();
        for (Flight flight: flights) {
            if (flightMap.containsKey(flight.getFrom())) {
                flightMap.get(flight.getFrom()).add(flight.getTo());
            } else {
                Set<City> citiesTo = new HashSet<>();
                citiesTo.add(flight.getTo());
                flightMap.put(flight.getFrom(), citiesTo);
            }
        }
        return flightMap;
    }
}
