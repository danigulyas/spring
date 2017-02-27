package com.dani.blog.base.service.support;

import com.dani.blog.base.data.DAO;
import com.dani.blog.base.service.BaseService;
import com.dani.blog.base.service.Transformer;

/**
 * @author dani
 */
public class TestService extends BaseService<TestEntity, TestDto, Long> {
    public TestService(DAO<TestEntity, Long> repository, Transformer<TestEntity, TestDto> transformer) {
        super(repository, transformer);
    }
}
