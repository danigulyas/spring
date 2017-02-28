package com.dani.blog.domain.comment;

import com.dani.blog.base.service.BaseService;
import com.dani.blog.data.CommentRepository;
import com.dani.blog.domain.Comment;
import com.dani.blog.domain.Post;
import com.dani.blog.domain.comment.request.CreateCommentRequest;
import com.dani.blog.domain.post.PostEntity;
import com.dani.blog.domain.post.PostService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class CommentService extends BaseService<CommentEntity, Comment, Long> {
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

    private CommentTransformer getTransformer() {
        return (CommentTransformer) transformer;
    }
}
