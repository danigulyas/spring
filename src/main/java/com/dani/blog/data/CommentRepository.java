package com.dani.blog.data;

import com.dani.blog.base.data.CrudRepository;
import com.dani.blog.domain.comment.CommentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CrudRepository for comment, those starting with read is fetching
 * @author dani
 */
@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByPostId(long id);
    CommentEntity findOneByIdAndPostId(long id, long postId);

    @EntityGraph(attributePaths = {"post"})
    List<CommentEntity> readAllByPostId(long id);
}
