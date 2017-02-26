package com.dani.blog.domain.post;

import com.dani.blog.base.service.BaseService;
import com.dani.blog.data.PostRepository;
import com.dani.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author dani
 */
@Service
public class PostService extends BaseService<PostEntity, Post, Long> {

    @Inject
    public PostService(PostRepository repository, PostTransformer transformer) {
        super(repository, transformer);
    }
}
