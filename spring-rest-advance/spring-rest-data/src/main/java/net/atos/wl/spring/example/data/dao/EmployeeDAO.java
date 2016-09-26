/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.data.dao;

import java.util.List;

import net.atos.wl.spring.example.common.dto.EmployeeSearchDto;
import net.atos.wl.spring.example.data.entity.Employee;

/**
 * Data Access Object for managing employee data.
 * 
 * @author Rupesh Deshmukh
 */
public interface EmployeeDAO extends GenericDAO<Employee> {

    /**
     * Method to find a particular employee for the given salary code.
     * 
     * @param salaryCode
     *            int.
     * @return <code>net.atos.wl.spring.example.data.entity.Employee</code>.
     */
    Employee findEmployeeBySalaryCode(final int salaryCode);

    /**
     * Method to find employees based on the given search criteria.
     * 
     * @param employeeSearch
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeSearch</code>
     *            .
     * @return List of
     *         <code>net.atos.wl.spring.example.data.entity.Employee</code>.
     */
    List<Employee> findEmployeesBySearchCriteria(final EmployeeSearchDto employeeSearch);
}
