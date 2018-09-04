package com.celo.annotations_based_wiring.dao.impl;

import com.celo.annotations_based_wiring.dao.BaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseAbstractDAO<T> implements BaseDAO<T>{

    @PersistenceContext
    private EntityManager em;

    private Class<T> clazz;

    public BaseAbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public T get(int id) {
        return em.find(clazz, id);
    }

}
