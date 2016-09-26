/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Data Transfer Object for Employee contact details.
 * 
 * @author Rupesh Deshmukh
 */
@Entity
@Table(name = "contact_details")
public class ContactDetails extends AuditableEntity {

    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = -1277499404238871383L;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @OneToMany(mappedBy = "contactDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> addresses;

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
    public List<Address> getAddresses() {
        return this.addresses;
    }

    /**
     * Setter for addresses.
     * 
     * @param addresses
     *            the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Custom method to bind address with contact details.
     * 
     * @param address
     *            <code>net.atos.wl.spring.example.data.entity.Address</code>.
     */
    public void addAddress(final Address address) {

        if (address != null) {
            address.setContactDetails(this);

            if (this.addresses != null) {
                this.addresses.add(address);
            } else {
                this.addresses = new ArrayList<>();
                this.addresses.add(address);
            }
        }
    }
}
