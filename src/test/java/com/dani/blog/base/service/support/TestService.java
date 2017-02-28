package com.dani.blog.base.service.support;

import com.dani.blog.base.data.CrudRepository;
import com.dani.blog.base.service.BaseCrudService;
import com.dani.blog.base.service.Transformer;

/**
 * @author dani
 */
public class TestService extends BaseCrudService<TestEntity, TestDto, Long> {
    public TestService(CrudRepository<TestEntity, Long> repository, Transformer<TestEntity, TestDto> transformer) {
        super(repository, transformer);
    }
}
