package com.mftplus.onlineshop.model.service;

import com.mftplus.onlineshop.model.entity.User;

import javax.persistence.Id;
import java.util.List;

public interface Service<T,I> {
    T save(T t) throws Exception;
    T edit(T t) throws Exception;
    T remove(I id) throws Exception;
    T findById(I id) throws Exception;
    List<T> findAll() throws Exception;
}
