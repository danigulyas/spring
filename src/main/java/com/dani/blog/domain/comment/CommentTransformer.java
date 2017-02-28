package com.dani.blog.domain.comment;

import com.dani.blog.base.service.ModelMapperTransformer;
import com.dani.blog.domain.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author dani
 */
@Component
@Transactional
public class CommentTransformer extends ModelMapperTransformer<CommentEntity, Comment> {

    @Inject
    public CommentTransformer(ModelMapper mapper) {
        super(mapper);
    }
}
