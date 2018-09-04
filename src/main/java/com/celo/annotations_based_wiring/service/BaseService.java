package com.celo.annotations_based_wiring.service;

public interface BaseService<T>{

    void save(T entity);

    T get(int id);

}
