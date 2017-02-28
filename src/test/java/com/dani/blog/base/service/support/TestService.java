package com.dani.blog.base.service.support;

import com.dani.blog.base.data.CrudRepository;
import com.dani.blog.base.service.BaseService;
import com.dani.blog.base.service.Transformer;

/**
 * @author dani
 */
public class TestService extends BaseService<TestEntity, TestDto, Long> {
    public TestService(CrudRepository<TestEntity, Long> repository, Transformer<TestEntity, TestDto> transformer) {
        super(repository, transformer);
    }
}
