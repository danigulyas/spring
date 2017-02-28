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
public class BaseCrudService<E, D, I extends Serializable> implements CrudService<E, D, I> {
    protected final Transformer<E, D> transformer;
    protected final CrudRepository<E, I> repository;

    public BaseCrudService(CrudRepository<E, I> repository, Transformer<E, D> transformer) {
        checkNotNull(repository);
        checkNotNull(transformer);

        this.repository = repository;
        this.transformer = transformer;
    }

    public List<D> findAll() {
        return repository.findAll().stream().map(transformer::fromEntity).collect(Collectors.toList());
    }

    public D find(I id) {
        return transformer.fromEntity(repository.findById(id));
    }

    public D create(D draft) {
        return transformer.fromEntity(repository.save(transformer.fromDto(draft)));
    }

    /**
     * @throws EmptyResultDataAccessException
     * @param id
     */
    public void delete(I id) {
        repository.delete(id);
    }


}
