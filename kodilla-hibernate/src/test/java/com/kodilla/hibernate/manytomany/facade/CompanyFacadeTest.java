package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTest {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyFacade facade;

    @Test
    public void shouldFindCompany() {
        // Given
        Company company = new Company("Crossing No1");
        Company company2 = new Company("Sun");
        Company company3 = new Company("MicR Inc.");
        Company company4 = new Company("Oracle RO");
        Company company5 = new Company("Micro/Audio Ltd.");

        companyDao.save(company);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        companyDao.save(company5);

        // When
        List<CompanyDto> companies = new ArrayList<>();
        try {
            companies = facade.findCompany("cro");
        } catch (CompanyNotFoundException e) {
            // do something
        }

        // Then
        assertEquals(2, companies.size());

        // CleanUp
        try {
            companyDao.delete(company);
            companyDao.delete(company2);
            companyDao.delete(company3);
            companyDao.delete(company4);
            companyDao.delete(company5);
        } catch (Exception e) {
            // do nothing
        }
    }

    @Test
    public void shouldFindEmployee() {
        // Given
        Employee employee = new Employee("Will", "Smith");
        Employee employee2 = new Employee("Tommy Lee", "Jones");
        Employee employee3 = new Employee("Jaden", "Smith");
        Employee employee4 = new Employee("Zoe", "Kravitz");

        employeeDao.save(employee);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);

        // When
        List<EmployeeDto> employees = new ArrayList<>();
        try {
            employees = facade.findEmployee("j");
        } catch (EmployeeNotFoundException e) {
            // do something
        }

        // Then
        assertEquals(2, employees.size());

        // CleanUp
        try {
            employeeDao.delete(employee);
            employeeDao.delete(employee2);
            employeeDao.delete(employee3);
            employeeDao.delete(employee4);
        } catch (Exception e) {
            // do nothing
        }
    }
}
