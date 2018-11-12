package com.kodilla.hibernate.manytomany.facade;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeDto {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final List<CompanyDto> companies = new ArrayList<>();

    public EmployeeDto(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<CompanyDto> getCompanies() {
        return companies;
    }
}
