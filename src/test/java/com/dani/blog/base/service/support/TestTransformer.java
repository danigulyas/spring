package com.dani.blog.base.service.support;

import com.dani.blog.base.service.ModelMapperTransformer;
import org.modelmapper.ModelMapper;

/**
 * @author dani
 */
public class TestTransformer extends ModelMapperTransformer<TestEntity, TestDto> {
    public TestTransformer() {
        super(new ModelMapper());
    }
}