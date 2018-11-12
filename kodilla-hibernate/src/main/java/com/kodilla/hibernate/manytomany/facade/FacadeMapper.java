package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacadeMapper {
    public List<CompanyDto> mapToCompanyDtoList(final List<Company> companyList) {
        return companyList.stream()
                .map(company -> new CompanyDto(company.getId(), company.getName()))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> mapToEmployeeDtoList(final List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName()))
                .collect(Collectors.toList());
    }
}
