/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Data Transfer Object for Employee data.
 * 
 * @author Rupesh Deshmukh
 */
@Entity
@Table(name = "employee")
public class Employee extends AuditableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -5903299397004480021L;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary_code", nullable = false)
    private Integer salaryCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ContactDetails contactDetails;

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
    public ContactDetails getContactDetails() {
        return this.contactDetails;
    }

    /**
     * Setter for contactDetails.
     * 
     * @param contactDetails
     *            the contactDetails to set
     */
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
}
