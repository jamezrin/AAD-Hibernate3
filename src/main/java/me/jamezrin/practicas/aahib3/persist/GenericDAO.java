package me.jamezrin.practicas.aahib3.persist;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T,ID extends Serializable> {
	void persist(T entity);
    void merge(T entity);
    void remove(ID id);
    T findById(ID id);
    List<T> findAll();
}
