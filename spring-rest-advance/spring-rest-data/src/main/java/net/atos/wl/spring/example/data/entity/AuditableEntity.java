/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.atos.wl.spring.example.data.listeners.AuditEntityListener;

/**
 * Abstract class to provide entity with properties used for auditing.
 * 
 * @author a120065
 */
@MappedSuperclass
@EntityListeners(value = {AuditEntityListener.class})
public abstract class AuditableEntity extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -3846660351249034784L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    /**
     * Getter for createdDate.
     *
     * @return the createdDate
     */
    public final Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Setter for createdDate.
     *
     * @param createdDate
     *            the createdDate to set
     */
    public final void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Getter for updatedDate.
     *
     * @return the updatedDate
     */
    public final Date getUpdatedDate() {
        return this.updatedDate;
    }

    /**
     * Setter for updatedDate.
     *
     * @param updatedDate
     *            the updatedDate to set
     */
    public final void setUpdatedDate(final Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
