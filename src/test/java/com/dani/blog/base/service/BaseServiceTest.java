package com.dani.blog.base.service;

import com.dani.blog.base.data.DAO;
import com.dani.blog.base.service.stub.TestDto;
import com.dani.blog.base.service.stub.TestEntity;
import com.dani.blog.base.service.stub.TestService;
import com.dani.blog.base.service.stub.TestTransformer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author dani
 */
public class BaseServiceTest {
    private DAO<TestEntity, Long> repository;
    private TestTransformer transformer;
    private TestService service;

    @Before
    public void setUp() {
        transformer = new TestTransformer();
        repository = getMockRepository();
        service = new TestService(repository, transformer);
    }

    @Test
    public void testFind() {
        final List<TestEntity> repositoryReturn = new ArrayList();
        repositoryReturn.add(new TestEntity(0L, "a"));
        repositoryReturn.add(new TestEntity(1L, "b"));

        when(repository.findAll()).thenReturn(repositoryReturn);

        final List<TestDto> result = service.findAll();

        assertEquals("Result and return has the same size.", repositoryReturn.size(), result.size());
        assertEquals("Keeps order.", repositoryReturn.get(0).getId(), result.get(0).getId());
    }

    @Test
    public void testFindById() {
        final Long id = 0L;
        final TestEntity entity = new TestEntity(id, "a");
        when(repository.findById(0L)).thenReturn(entity);

        TestDto result = service.find(id);

        assertNotNull(result);
        assertEquals("Has the same id.", entity.getId(), result.getId());
    }

    @Test
    public void testFindByIdWithNull() {
        final Long id = 13L;
        when(repository.findById(id)).thenReturn(null);

        TestDto result = service.find(id);

        assertNull(result);
    }

    @Test
    public void testCreate() {
        final TestDto draft = new TestDto(null, "hello");
        final TestEntity entity = new TestEntity(13L, draft.getTest());
        when(repository.save(any(TestEntity.class))).thenReturn(entity);

        final TestDto result = service.create(draft);

        assertNotNull(result);
        assertEquals("Has same id as returned from repository.", entity.getId(), result.getId());
        assertEquals("Has same test as returned from repository.", entity.getTest(), result.getTest());
    }

    @Test
    public void testDelete() {
        final Long idToBeDeleted = 42L;

        service.delete(idToBeDeleted);

        verify(repository, times(1)).delete(idToBeDeleted);
    }

    protected DAO<TestEntity, Long> getMockRepository() {
        return mock(DAO.class);
    }
}
