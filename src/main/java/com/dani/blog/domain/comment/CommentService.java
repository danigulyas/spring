package com.dani.blog.domain.comment;

import com.dani.blog.base.service.BaseCrudService;
import com.dani.blog.data.CommentRepository;
import com.dani.blog.domain.Comment;
import com.dani.blog.domain.Post;
import com.dani.blog.domain.comment.request.CreateCommentRequest;
import com.dani.blog.domain.post.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author dani
 */
@Service
@Transactional
public class CommentService extends BaseCrudService<CommentEntity, Comment, Long> {
    private final PostService postService;

    @Inject
    public CommentService(CommentRepository repository, CommentTransformer transformer, PostService postService) {
        super(repository, transformer);

        checkNotNull(postService);
        this.postService = postService;
    }

    /**
     * Creates a comment.
     * @param req
     * @return
     */
    public Comment create(@Valid CreateCommentRequest req, long postId) {
        Post post = getPostById(postId);
        Comment draft = new Comment();

        draft.setContent(req.getContent());
        draft.setPost(post);

        return transformer.fromEntity(repository.save(transformer.fromDto(draft)));
    }

    public List<Comment> findAllByPostId(long id) {
        Post post = getPostById(id);

        return getRepository()
                .readAllByPostId(post.getId())
                .stream()
                .map(transformer::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public Comment findByIdAndPostId(long id, long postId) {
        CommentEntity entity = repository.findById(id);
        Comment comment = transformer.fromEntity(entity);

        Assert.notNull(comment, "Comment with id #" + id + " not found.");
        Assert.isTrue(comment.getPost().getId() == postId,
                "The comment referenced by the id doesn't belong to the post.");

        return comment;
    }

    private Post getPostById(long id) {
        checkNotNull(id);

        Post post = postService.find(id);

        Assert.notNull(post, "Post with id #" + id + " not found.");

        return post;
    }

    private CommentRepository getRepository() {
        return (CommentRepository) repository;
    }

    private CommentTransformer getTransformer() {
        return (CommentTransformer) transformer;
    }
}
