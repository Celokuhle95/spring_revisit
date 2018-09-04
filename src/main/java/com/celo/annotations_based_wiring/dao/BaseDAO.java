package com.celo.annotations_based_wiring.dao;

public interface BaseDAO<T> {
    void save(T entity);

    T get(int id);
}
