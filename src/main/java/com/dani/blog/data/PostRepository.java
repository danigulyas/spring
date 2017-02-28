package com.dani.blog.data;

import com.dani.blog.base.data.CrudRepository;
import com.dani.blog.domain.post.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dani
 */
@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
