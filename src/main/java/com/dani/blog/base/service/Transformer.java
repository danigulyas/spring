package com.dani.blog.base.service;

/**
 * Transformer between entities and DTO's.
 * @param <E> Entity
 * @param <D> DTO
 */
public interface Transformer<E, D> {
    E fromDto(D dto);
    D fromEntity(E entity);
}
