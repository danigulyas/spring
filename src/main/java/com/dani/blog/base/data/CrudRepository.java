package com.dani.blog.base.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * CrudRepository.
 * @param <E> entity
 * @param <I> identifier
 */
public interface CrudRepository<E, I extends Serializable> extends JpaRepository<E, I> {
}
