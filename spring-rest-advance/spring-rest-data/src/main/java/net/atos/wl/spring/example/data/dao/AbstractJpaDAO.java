/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example.data.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract JPA DAO within common JPA configuration to be applied across all
 * DAO's.
 * 
 * @param <T>
 *            JPA Entity
 * @author a120065
 */
public abstract class AbstractJpaDAO<T extends Serializable> implements GenericDAO<T> {

    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(final T entity) {
        this.entityManager.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T read(final Integer id) {
        return this.entityManager.find(this.clazz, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T update(final T entity) {
        return this.entityManager.merge(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final T entity) {
        this.entityManager.remove(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(final int entityId) {

        // Find entity by given Id.
        final T entity = this.read(entityId);

        // Delete the entity.
        this.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return this.entityManager.createQuery("from " + this.clazz.getName()).getResultList();
    }

    /**
     * Setter for Clazz.
     * 
     * @param clazzToSet
     */
    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
}
