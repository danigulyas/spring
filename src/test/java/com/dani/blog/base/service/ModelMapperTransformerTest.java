package com.dani.blog.base.service;

import lombok.*;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static junit.framework.Assert.assertEquals;

/**
 * @author dani
 */
public class ModelMapperTransformerTest {
    private TestTransformer transformer;
    private TestEntity entity;
    private TestDto dto;

    @Before
    public void setUp() {
        transformer = new TestTransformer();
        entity = new TestEntity(0L, "test");
        dto = new TestDto(0L, "test");
    }


    @Test
    public void testConvertsFromEntityCorrectly() {
        TestDto result = transformer.fromEntity(entity);

        assertEquals("Has the same id.", entity.getId(), result.getId());
        assertEquals("Has the same fields.", entity.getTest(), result.getTest());
    }

    @Test
    public void testConvertsFromDtoCorrectly() {
        TestEntity result = transformer.fromDto(dto);

        assertEquals("Has the same id.", dto.getId(), result.getId());
        assertEquals("Has the same field.", dto.getTest(), result.getTest());
    }


    class TestTransformer extends ModelMapperTransformer<TestEntity, TestDto> {
        public TestTransformer() {
            super(new ModelMapper());
        }
    }
}

