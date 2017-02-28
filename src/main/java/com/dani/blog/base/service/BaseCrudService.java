package com.dani.blog.base.service;

import com.dani.blog.base.data.CrudRepository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Base implementation for {@link CrudService}
 * @param <E> Entity
 * @param <D> DTO
 * @param <I> Identifier
 */
public abstract class BaseCrudService<E, D, I extends Serializable> implements CrudService<E, D, I> {
    protected final Transformer<E, D> transformer;

    public BaseCrudService(Transformer<E, D> transformer) {
        checkNotNull(transformer);
        this.transformer = transformer;
    }

    public List<D> findAll() {
        return getRepository().findAll().stream().map(transformer::fromEntity).collect(Collectors.toList());
    }

    public D find(I id) {
        return transformer.fromEntity(getRepository().findOne(id));
    }

    public D create(D draft) {
        return transformer.fromEntity(getRepository().save(transformer.fromDto(draft)));
    }

    /**
     * @throws EmptyResultDataAccessException
     * @param id
     */
    public void delete(I id) {
        getRepository().delete(id);
    }

    protected abstract CrudRepository<E, I> getRepository();
}
