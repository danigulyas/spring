package com.dani.blog.domain.comment;

import com.dani.blog.base.service.BaseService;
import com.dani.blog.data.CommentRepository;
import com.dani.blog.domain.Comment;
import com.dani.blog.domain.Post;
import com.dani.blog.domain.post.PostService;
import javassist.NotFoundException;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author dani
 */
public class CommentService extends BaseService<CommentEntity, Comment, Long> {
    private final PostService postService;

    @Inject
    public CommentService(CommentRepository repository, CommentTransformer transformer, PostService postService) {
        super(repository, transformer);

        checkNotNull(postService);
        this.postService = postService;
    }

    public List<Comment> findAllByPostId(long id) {
        Post post = getPostById(id);

        return getRepository()
                .findAllByPostId(post.getId())
                .stream()
                .map(transformer::fromEntity)
                .collect(Collectors.toList());
    }

    public Comment findByIdAndPostId(long id, long postId) {
        Comment comment = transformer.fromEntity(repository.findById(id));

        if(comment == null)
            throw new IllegalStateException("Comment with id #" + id + " not found.");

        if(comment.getPost().getId() != postId)
            throw new IllegalStateException("Comment #" + id + " doesn't belong to post #" + postId);

        return comment;
    }

    private Post getPostById(long id) {
        checkNotNull(id);

        Post post = postService.find(id);

        if(post == null) throw new IllegalStateException("Couldn't find post with id #" + id);

        return post;
    }

    private CommentRepository getRepository() {
        return (CommentRepository) repository;
    }
}
