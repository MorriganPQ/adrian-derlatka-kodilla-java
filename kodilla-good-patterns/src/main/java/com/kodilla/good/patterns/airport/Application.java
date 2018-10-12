package com.kodilla.good.patterns.airport;

import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Flight> flights = FlightDatabase.create();
        Map<City, Set<City>> flightMap = FlightMap.create(flights);

        City warsaw = new City("Warsaw");
        City losAngeles = new City("Los Angeles");

        Set<City> citiesTo = Search.FindAllFlightFrom(warsaw, flightMap);
        System.out.println("All flights from " + warsaw.getName() + ":");
        citiesTo.stream()
                .forEach(cityTo -> System.out.println(warsaw.getName() + "\t->\t" + cityTo.getName()));

        Set<City> citiesFrom = Search.FindAllFlightTo(losAngeles, flightMap);
        System.out.println("\nAll flights to " + losAngeles.getName() + ":");
        citiesFrom.stream()
                .forEach(cityFrom -> System.out.println(cityFrom.getName() + "\t->\t" + losAngeles.getName()));

        Set<City> citiesThrough = Search.FindIndirectFlight(warsaw, losAngeles, flightMap);
        System.out.println("\nAll indirect flights from " + warsaw.getName() + " to " + losAngeles.getName() + ":");
        citiesThrough.stream()
                .forEach(cityThrough -> System.out.println(warsaw.getName() + "\t->\t" + cityThrough.getName() + "\t->\t" + losAngeles.getName()));
    }
}
