package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        // When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        // Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        // CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            // do nothing
        }
    }

    @Test
    public void testFindByLastNameEmployee() {
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
        List<Employee> smiths = employeeDao.findByLastName("smith");

        // Then
        Assert.assertEquals(2, smiths.size());

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

    @Test
    public void testFindByFirstThreeLettersOfNameCompany() {
        // Given
        Company company = new Company("Microsoft");
        Company company2 = new Company("Sun");
        Company company3 = new Company("Microsystems Inc.");
        Company company4 = new Company("Oracle");
        Company company5 = new Company("Mics/Audio Ltd.");

        companyDao.save(company);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        companyDao.save(company5);

        // When
        List<Company> mic = companyDao.findByFirstThreeLettersOfName("mic");

        // Then
        Assert.assertEquals(3, mic.size());

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
}
