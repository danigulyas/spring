package com.dani.blog.data;

import com.dani.blog.base.data.DAO;
import com.dani.blog.domain.comment.CommentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dani
 */
@Repository
public interface CommentRepository extends DAO<CommentEntity, Long> {
    List<CommentEntity> findAll();
    List<CommentEntity> findAllByPostId(long id);
}
