package com.dani.blog.base.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * DAO.
 * @param <E> entity
 * @param <I> identifier
 */
public interface DAO<E, I extends Serializable> extends JpaRepository<E, I> {
    E findById(I id);
    List<E> findAll();
}
