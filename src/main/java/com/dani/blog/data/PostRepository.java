package com.dani.blog.data;

import com.dani.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dani
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();
}
