package com.dani.blog.domain.comment;

import com.dani.blog.base.service.ModelMapperTransformer;
import com.dani.blog.base.service.Transformer;
import com.dani.blog.domain.Comment;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

/**
 * @author dani
 */
public class CommentTransformer extends ModelMapperTransformer<CommentEntity, Comment> {

    @Inject
    public CommentTransformer(ModelMapper mapper) {
        super(mapper);
    }
}
