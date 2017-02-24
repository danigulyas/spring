package com.dani.blog.base.service;

import java.io.Serializable;
import java.util.List;

/**
 * Service, working with Entity and representing it as a D (DTO) to the outside world.
 * @param <E> Entity.
 * @param <D> DTO.
 * @param <I> Identifier.
 */
public interface Service<E, D, I extends Serializable> {
    D create(D draft);

    D find(I id);
    List<D> findAll();

    void delete(I id);
}
