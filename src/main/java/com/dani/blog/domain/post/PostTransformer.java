package com.dani.blog.domain.post;

import com.dani.blog.base.service.ModelMapperTransformer;
import com.dani.blog.domain.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dani
 */
@Component
public class PostTransformer extends ModelMapperTransformer<PostEntity, Post> {

    @Autowired
    public PostTransformer(ModelMapper mapper) {
        super(mapper);
    }
}
