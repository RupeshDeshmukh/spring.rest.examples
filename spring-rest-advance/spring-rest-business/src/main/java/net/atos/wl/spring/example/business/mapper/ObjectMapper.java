/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.business.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.atos.wl.spring.example.common.dto.EmployeeDto;
import net.atos.wl.spring.example.data.entity.Employee;

/**
 * Dozer object mapper for mapping DTO to entity and vice versa.
 * 
 * @author a120065
 */
@Component
public class ObjectMapper {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    /**
     * Method to map EmployeeDto to Employee entity.
     * 
     * @param employeeDto
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     * @return <code>net.atos.wl.spring.example.data.entity.Employee</code>.
     */
    public Employee mapEmployeeDtoToEntity(final EmployeeDto employeeDto) {

        return this.dozerBeanMapper.map(employeeDto, Employee.class);
    }

    /**
     * Method to map Employee entity to EmployeeDto.
     * 
     * @param employee
     *            <code>net.atos.wl.spring.example.data.entity.Employee</code>.
     * @return <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     */
    public EmployeeDto mapEmployeeEntityToDto(final Employee employee) {

        return this.dozerBeanMapper.map(employee, EmployeeDto.class);
    }

    /**
     * Method to map information from EmployeeDto to Employee entity fetched
     * from DB.
     * 
     * @param employeeDto
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>
     * @param employeeFromDb
     *            <code>net.atos.wl.spring.example.data.entity.Employee</code>.
     */
    public void map(final EmployeeDto employeeDto, final Employee employeeFromDb) {
        this.dozerBeanMapper.map(employeeDto, employeeFromDb);
    }
}
