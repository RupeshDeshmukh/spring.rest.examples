/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.atos.wl.spring.example.business.service.EmployeeService;
import net.atos.wl.spring.example.common.dto.EmployeeDto;

/**
 * RESTful service controller for managing employees.
 * 
 * @author a120065
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * REST service to create employee.
     * 
     * @param employeeDto
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     * @param ucBuilder
     *            <code>org.springframework.web.util.UriComponentsBuilder</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/employee/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createEmployee(@RequestBody final EmployeeDto employeeDto,
                                               final UriComponentsBuilder ucBuilder) {

        this.employeeService.create(employeeDto);

        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employeeDto.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * REST service to get employee by given id.
     * 
     * @param id
     *            Integer of the employee to be searched.
     * @return ResponseEntity with employee and HTTP status.
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") final Integer id) {

        final EmployeeDto employeeDto = this.employeeService.read(id);

        if (employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /**
     * REST service to update employee by given details.
     * 
     * @param id
     *            Integer of the employee to be searched.
     * @param employee
     *            <code>net.atos.wl.spring.example.common.dto.EmployeeDto</code>.
     * @return ResponseEntity with employee and HTTP status.
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") final Integer id,
                                                      @RequestBody final EmployeeDto employee) {

        final EmployeeDto employeeDto = this.employeeService.read(id);

        if (employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employeeService.update(employeeDto);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /**
     * REST service to delete employee by given id.
     * 
     * @param id
     *            Integer of the employee to be searched.
     * @return ResponseEntity with employee and HTTP status.
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeDto> deleteUser(@PathVariable("id") final Integer id) {

        final EmployeeDto employeeDto = this.employeeService.read(id);

        if (employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employeeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
