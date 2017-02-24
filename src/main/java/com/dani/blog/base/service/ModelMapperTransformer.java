package com.dani.blog.base.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Abstract implementation of transformer with ModelMapper.
 * @param <E> Entity
 * @param <D> DTO
 */
public class ModelMapperTransformer<E, D> implements Transformer<E, D> {
    protected final ModelMapper mapper;
    protected final Class<E> entityClazz;
    protected final Class<D> dtoClazz;

    public ModelMapperTransformer(ModelMapper mapper) {
        checkNotNull(mapper);

        this.mapper = mapper;
        // Fetch classes bound to generic params at runtime.
        this.entityClazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dtoClazz = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public E fromDto(D dto) {
        return mapper.map(dto, entityClazz);
    }

    public D fromEntity(E entity) {
        return mapper.map(entity, dtoClazz);
    }
}
