/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.wl.spring.example.business.mapper.ObjectMapper;
import net.atos.wl.spring.example.common.dto.EmployeeDto;
import net.atos.wl.spring.example.common.dto.EmployeeSearchDto;
import net.atos.wl.spring.example.data.dao.EmployeeDAO;
import net.atos.wl.spring.example.data.entity.Employee;

/**
 * Implementation class for
 * <code>net.atos.wl.spring.example.business.service.EmployeeService</code>
 * 
 * @author Rupesh Deshmukh
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Employee DAO instance that will be initialized by spring using
     * constructor injection.
     */
    @Autowired
    private EmployeeDAO employeDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeDto create(final EmployeeDto employeeDto) {

        // First map all information passed from EmployeeDto to Employee entity.
        final Employee employee = this.objectMapper.mapEmployeeDtoToEntity(employeeDto);

        // Invoke DAO to persist the employee data.
        this.getEmployeDAO().create(employee);

        // Finally reverse map entity information to the EmployeeDto.
        return this.objectMapper.mapEmployeeEntityToDto(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeDto read(final Integer id) {

        // Fetch employee record for the given Id.
        final Employee employee = this.getEmployeDAO().read(id);

        // If employee exists then map entity information to EmployeeDto.
        if (employee != null) {
            return this.objectMapper.mapEmployeeEntityToDto(employee);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final EmployeeDto employeeDto) {

        // Fetch employee record for the given Id.
        final Employee employeeFromDb = this.getEmployeDAO().read(employeeDto.getId());

        // Map updated information from EmployeeDto to employee entity.
        this.objectMapper.map(employeeDto, employeeFromDb);

        // Finally invoke DAO to update details.
        this.getEmployeDAO().update(employeeFromDb);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Integer id) {

        this.getEmployeDAO().deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeDto findEmployeeBySalaryCode(final int salaryCode) {

        // Fetch employee record for the given salary code.
        final Employee employee = this.getEmployeDAO().findEmployeeBySalaryCode(salaryCode);

        // If employee exists then map entity information to EmployeeDto.
        if (employee != null) {
            return this.objectMapper.mapEmployeeEntityToDto(employee);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeDto> findAllEmployees() {

        // First fetch all employees by invoking DAO.
        final List<Employee> employees = this.getEmployeDAO().findAll();

        // If employees are found them iterate through the list and map all
        // entities to EmployeeDto.
        if (employees != null && !employees.isEmpty()) {
            final List<EmployeeDto> employeeDtos = new ArrayList<>();

            for (final Employee employee : employees) {
                employeeDtos.add(this.objectMapper.mapEmployeeEntityToDto(employee));
            }

            return employeeDtos;
        }

        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeDto> findEmployeesBySearchCriteria(final EmployeeSearchDto employeeSearchDto) {

        // First fetch employees based on the given search criteria.
        final List<Employee> employees = this.getEmployeDAO().findEmployeesBySearchCriteria(employeeSearchDto);

        // If employees are found them iterate through the list and map all
        // entities to EmployeeDto.
        if (employees != null && !employees.isEmpty()) {
            final List<EmployeeDto> employeeDtos = new ArrayList<>();

            for (final Employee employee : employees) {
                employeeDtos.add(this.objectMapper.mapEmployeeEntityToDto(employee));
            }

            return employeeDtos;
        }

        return new ArrayList<>();
    }

    /**
     * Getter for employeDAO.
     * 
     * @return the employeDAO
     */
    public EmployeeDAO getEmployeDAO() {
        return this.employeDAO;
    }

    /**
     * Setter for employeDAO.
     * 
     * @param employeDAO
     *            the employeDAO to set
     */
    public void setEmployeDAO(EmployeeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }

}
