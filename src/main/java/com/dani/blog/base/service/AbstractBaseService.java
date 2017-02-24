package com.dani.blog.base.service;

import com.dani.blog.base.data.DAO;
import javassist.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Base implementation for {@link Service}
 * @param <E> Entity
 * @param <D> DTO
 * @param <I> Identifier
 */
public class AbstractBaseService<E, D, I extends Serializable> implements Service<E, D, I> {
    protected final Transformer<E, D> transformer;
    protected final DAO<E, I> repository;

    public AbstractBaseService(DAO<E, I> repository, Transformer<E, D> transformer) {
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
        E entity = repository.findById(id);
    }


}
