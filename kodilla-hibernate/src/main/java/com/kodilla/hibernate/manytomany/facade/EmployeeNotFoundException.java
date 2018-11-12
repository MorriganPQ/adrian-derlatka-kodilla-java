package com.kodilla.hibernate.manytomany.facade;

public class EmployeeNotFoundException extends Exception {
    public static final String ERR_EMPLOYEE_NOT_FOUND = "Employee not found";

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
