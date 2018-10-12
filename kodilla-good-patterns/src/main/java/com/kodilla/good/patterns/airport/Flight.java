package com.kodilla.good.patterns.airport;

public class Flight {
    private City from;
    private City to;

    public Flight(final City from, final City to) {
        this.from = from;
        this.to = to;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        Flight flight = (Flight) o;
        return from.equals(flight.from) && to.equals(flight.to);
    }

    @Override
    public int hashCode() {
        return from.hashCode() * to.hashCode();
    }
}
