package com.mldtsv.amigossecurity.repository;

import java.util.Collection;
import java.util.Optional;

public interface AbstractDAO<T, K> {
    Optional<T> findById(K id);
    Collection<T> getAll();
    void create(T item);
    void update(K id, T item);
    void delete(K id);
}
