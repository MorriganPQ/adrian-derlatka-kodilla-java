package com.kodilla.good.patterns.airport;

public class City {
    private String name;

    public City(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
