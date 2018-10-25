package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Employee.findByLastName",
        query = "FROM Employee WHERE LOWER(lastName) = :LASTNAME"
)
@Entity
@Table(name = "employees")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "employee_id", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_company_employee",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "company_id")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
