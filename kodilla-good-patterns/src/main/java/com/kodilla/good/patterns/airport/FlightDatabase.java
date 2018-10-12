package com.kodilla.good.patterns.airport;

import java.util.HashSet;
import java.util.Set;

public class FlightDatabase {
    public static Set<Flight> create() {
        City warsaw = new City("Warsaw");
        City london = new City("London");
        City rome = new City("Rome");
        City paris = new City("Paris");
        City berlin = new City("Berlin");
        City losAngeles = new City("Los Angeles");
        City tokyo = new City("Tokyo");
        City moscow = new City("Moscow");

        Flight flight1 = new Flight(warsaw, london);
        Flight flight2 = new Flight(warsaw, rome);
        Flight flight3 = new Flight(london, losAngeles);
        Flight flight4 = new Flight(london, moscow);
        Flight flight5 = new Flight(rome, berlin);
        Flight flight6 = new Flight(rome, losAngeles);
        Flight flight7 = new Flight(paris, london);
        Flight flight8 = new Flight(paris, losAngeles);
        Flight flight9 = new Flight(paris, moscow);
        Flight flight10 = new Flight(tokyo, moscow);
        Flight flight11 = new Flight(moscow, berlin);
        Flight flight12 = new Flight(berlin, paris);
        Flight flight13 = new Flight(warsaw, berlin);
        Flight flight14 = new Flight(rome, tokyo);
        Flight flight15 = new Flight(berlin, moscow);
        Flight flight16 = new Flight(losAngeles, tokyo);

        Set<Flight> flights = new HashSet<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
        flights.add(flight7);
        flights.add(flight8);
        flights.add(flight9);
        flights.add(flight10);
        flights.add(flight11);
        flights.add(flight12);
        flights.add(flight13);
        flights.add(flight14);
        flights.add(flight15);
        flights.add(flight16);

        return flights;
    }
}
