/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import net.atos.wl.spring.example.common.enums.State;

/**
 * Abstract class to with common properties for entities
 * 
 * @author a120065
 */
@MappedSuperclass
public abstract class PersistableEntity implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 3545323257834288031L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Long version = 0L;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_state", nullable = false)
    private State recordState = State.ACTIVE;

    /**
     * Getter for id.
     *
     * @return the id
     */
    public final Integer getId() {
        return this.id;
    }

    /**
     * Setter for id.
     *
     * @param id
     *            the id to set
     */
    public final void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Getter for version.
     *
     * @return the version
     */
    public final Long getVersion() {
        return this.version;
    }

    /**
     * Setter for version.
     *
     * @param version
     *            the version to set
     */
    public final void setVersion(final Long version) {
        this.version = version;
    }

    /**
     * Getter for recordState.
     *
     * @return the recordState
     */
    public final State getRecordState() {
        return this.recordState;
    }

    /**
     * Setter for recordState.
     *
     * @param recordState
     *            the recordState to set
     */
    public final void setRecordState(final State recordState) {
        this.recordState = recordState;
    }

}
