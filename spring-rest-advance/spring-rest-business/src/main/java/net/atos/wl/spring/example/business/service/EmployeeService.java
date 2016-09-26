/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.business.service;

import java.util.List;

import net.atos.wl.spring.example.common.dto.EmployeeDto;
import net.atos.wl.spring.example.common.dto.EmployeeSearchDto;

/**
 * Service for managing employee information.
 * 
 * @author Rupesh Deshmukh
 */
public interface EmployeeService {

    /**
     * Method create a new employee record in DB.
     * 
     * @param employee
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>
     *            .
     * @return <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     */
    EmployeeDto create(final EmployeeDto employee);

    /**
     * Method to fetch employee details for the given employee Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     */
    EmployeeDto read(final Integer id);

    /**
     * Method to update employee details.
     * 
     * @param employee
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>
     *            .
     */
    void update(final EmployeeDto employee);

    /**
     * Method to delete the given employee record from DB.
     * 
     * @param id
     *            Integer.
     */
    void delete(final Integer id);

    /**
     * Method to find a particular employee for the given salary code.
     * 
     * @param salaryCode
     *            int.
     * @return <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     */
    EmployeeDto findEmployeeBySalaryCode(final int salaryCode);

    /**
     * Method to find all employees.
     * 
     * @return List of
     *         <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     */
    List<EmployeeDto> findAllEmployees();

    /**
     * Method to find employees based on the given search criteria.
     * 
     * @param employeeSearch
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeSearchDto</code>
     *            .
     * @return List of
     *         <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     */
    List<EmployeeDto> findEmployeesBySearchCriteria(final EmployeeSearchDto employeeSearch);
}
