package com.kodilla.good.patterns.airport;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Search {
    public static Set<City> FindAllFlightFrom(final City cityFrom, final Map<City, Set<City>> flightMap) {
        return flightMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(cityFrom))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet());
    }

    public static Set<City> FindAllFlightTo(final City cityTo, final Map<City, Set<City>> flightMap) {
        return flightMap.entrySet().stream()
                .filter(entry -> entry.getValue().contains(cityTo))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static Set<City> FindIndirectFlight(final City cityFrom, final City cityTo, final Map<City, Set<City>> flightMap) {
        final Set<City> flightsPossibleTransfer = FindAllFlightFrom(cityFrom, flightMap);
        return flightMap.entrySet().stream()
                .filter(entry -> {
                    for (City cityThrough: flightsPossibleTransfer) {
                        if (entry.getKey().equals(cityThrough) && entry.getValue().contains(cityTo)) {
                            return true;
                        }
                    }
                    return false;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
