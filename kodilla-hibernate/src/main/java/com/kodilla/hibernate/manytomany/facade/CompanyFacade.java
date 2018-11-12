package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public final class CompanyFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    @Autowired
    private FacadeMapper mapper;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<CompanyDto> findCompany(final String partialName) throws CompanyNotFoundException {
        List<CompanyDto> companies = mapper.mapToCompanyDtoList(companyDao.findByPartialName("%" + partialName + "%").orElse(new ArrayList<>()));
        long size = companies.size();
        if (size > 0) {
            LOGGER.info("Found " + ((size == 1) ? " company" : " companies"));
        } else {
            LOGGER.error(CompanyNotFoundException.ERR_COMPANY_NOT_FOUND);
            throw new CompanyNotFoundException(CompanyNotFoundException.ERR_COMPANY_NOT_FOUND);
        }
        return companies;
    }

    public List<EmployeeDto> findEmployee(final String partialName) throws EmployeeNotFoundException {
        List<EmployeeDto> employees = mapper.mapToEmployeeDtoList(employeeDao.findByPartialName("%" + partialName + "%").orElse(new ArrayList<>()));
        long size = employees.size();
        if (size > 0) {
            LOGGER.info("Found " + ((size == 1) ? " employee" : " employees"));
        } else {
            LOGGER.error(EmployeeNotFoundException.ERR_EMPLOYEE_NOT_FOUND);
            throw new EmployeeNotFoundException(EmployeeNotFoundException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employees;
    }
}
