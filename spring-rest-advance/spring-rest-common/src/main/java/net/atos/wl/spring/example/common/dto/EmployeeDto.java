/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.common.dto;

import java.io.Serializable;

/**
 * Employee DTO
 * 
 * @author a120065
 */
public class EmployeeDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 847059512586686426L;

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer salaryCode;

    private ContactDetailsDto contactDetails;

    /**
     * Getter for id.
     *
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for id.
     *
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for firstName.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for firstName.
     *
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName.
     *
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for lastName.
     *
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for salaryCode.
     *
     * @return the salaryCode
     */
    public Integer getSalaryCode() {
        return this.salaryCode;
    }

    /**
     * Setter for salaryCode.
     *
     * @param salaryCode
     *            the salaryCode to set
     */
    public void setSalaryCode(Integer salaryCode) {
        this.salaryCode = salaryCode;
    }

    /**
     * Getter for contactDetails.
     *
     * @return the contactDetails
     */
    public ContactDetailsDto getContactDetails() {
        return this.contactDetails;
    }

    /**
     * Setter for contactDetails.
     *
     * @param contactDetails
     *            the contactDetails to set
     */
    public void setContactDetails(ContactDetailsDto contactDetails) {
        this.contactDetails = contactDetails;
    }

}
