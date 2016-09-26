/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.common.dto;

import java.io.Serializable;

/**
 * DTO for employee search.
 * 
 * @author Rupesh Deshmukh
 */
public class EmployeeSearchDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -575780373564009845L;

    private String firstName;
    private String lastName;
    private Integer salaryCode;
    private String emailAddress;
    private String mobileNumber;

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
     * Getter for emailAddress.
     * 
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Setter for emailAddress.
     * 
     * @param emailAddress
     *            the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Getter for mobileNumber.
     * 
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * Setter for mobileNumber.
     * 
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EmployeeSearch [firstName=" + firstName + ", lastName=" + lastName + ", salaryCode=" + salaryCode
                        + ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + "]";
    }

}
