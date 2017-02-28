package com.dani.blog.base.service.support;

import com.dani.blog.base.data.CrudRepository;
import com.dani.blog.base.service.BaseCrudService;
import com.dani.blog.base.service.Transformer;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author dani
 */
public class TestService extends BaseCrudService<TestEntity, TestDto, Long> {
    protected final CrudRepository<TestEntity, Long> repository;

    public TestService(CrudRepository<TestEntity, Long> repository, Transformer<TestEntity, TestDto> transformer) {
        super(transformer);

        checkNotNull(repository);
        this.repository = repository;
    }

    protected CrudRepository<TestEntity, Long> getRepository() {
        return repository;
    }
}
