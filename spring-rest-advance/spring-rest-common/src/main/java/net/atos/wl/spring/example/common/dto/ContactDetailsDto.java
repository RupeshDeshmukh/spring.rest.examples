/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Contact Details DTO.
 * 
 * @author a120065
 */
public class ContactDetailsDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -5083190898091392199L;

    private String emailAddress;

    private String mobileNumber;

    private List<AddressDto> addresses;

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

    /**
     * Getter for addresses.
     *
     * @return the addresses
     */
    public List<AddressDto> getAddresses() {
        return this.addresses;
    }

    /**
     * Setter for addresses.
     *
     * @param addresses
     *            the addresses to set
     */
    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
