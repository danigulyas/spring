package com.dani.blog.data;

import com.dani.blog.base.data.DAO;
import com.dani.blog.domain.comment.CommentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dani
 */
@Repository
public interface CommentRepository extends DAO<CommentEntity, Long> {

    @EntityGraph(value = "Comment.post", type = EntityGraph.EntityGraphType.LOAD)
    List<CommentEntity> findAll();

    @EntityGraph(value = "Comment.post", type = EntityGraph.EntityGraphType.LOAD)
    List<CommentEntity> findAllByPostId(long id);

    @EntityGraph(value = "Comment.post", type = EntityGraph.EntityGraphType.LOAD)
    CommentEntity findOneByIdAndPostId(long id, long postId);
}
