package com.dani.blog.data;

import com.dani.blog.domain.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dani
 */
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAll();
}
