package com.dani.blog.domain.post;

import com.dani.blog.base.service.BaseCrudService;
import com.dani.blog.data.PostRepository;
import com.dani.blog.domain.Post;
import com.dani.blog.domain.post.request.CreatePostRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.Valid;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author dani
 */
@Service
public class PostService extends BaseCrudService<PostEntity, Post, Long> {
    protected final PostRepository repository;

    @Inject
    public PostService(PostRepository repository, PostTransformer transformer) {
        super(transformer);

        checkNotNull(repository);
        this.repository = repository;
    }

    public Post create(@Valid CreatePostRequest req) {
        PostEntity entity = new PostEntity(req.getName(), req.getContent());

        return transformer.fromEntity(repository.save(entity));
    }

    protected PostRepository getRepository() {
        return repository;
    }
}
