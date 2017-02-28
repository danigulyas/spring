package com.dani.blog.web;

import com.dani.blog.domain.Comment;
import com.dani.blog.domain.comment.CommentService;
import com.dani.blog.domain.comment.request.CreateCommentRequest;
import com.dani.blog.web.support.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * @author dani
 */
@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CommentController {
    private final CommentService service;

    @GetMapping
    public List<Comment> getAll(@PathVariable("postId") long postId) {
        try {
            final List<Comment> comments = service.findAllByPostId(postId);
            if(comments.isEmpty()) throw new EntityNotFoundException();

            return comments;
        } catch(IllegalStateException ise) {
            throw new EntityNotFoundException();
        }
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable("postId") long postId, @PathVariable("id") long commentId) {
        try {
            final Comment comment = service.findByIdAndPostId(commentId, postId);

            return comment;
        } catch(IllegalStateException ise) {
            throw new EntityNotFoundException();
        }
    }

    /**
     * Deletes a comment from the post's context if the comment referenced belongs to the given post.
     * @param postId
     * @param commentId
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("postId") long postId, @PathVariable("id") long commentId) {
        try {
            final Comment comment = service.findByIdAndPostId(postId, commentId);

            if(comment == null) throw new EntityNotFoundException();

            service.delete(comment.getId());
        } catch(IllegalStateException ise) {
            throw new EntityNotFoundException();
        }
    }

    /**
     * This is double work ({@link Valid} is used at {@link CommentService} as well), this is a trade of performance
     * for convenience, this way we don't have to figure out how to pass the errors to the presentation layer,
     * Spring already helps with that.
     * @param dto is the converted pojo.
     * @return the created comment.
     */
    @PostMapping
    public Comment create(@Valid @RequestBody CreateCommentRequest dto, @PathVariable long postId) {
        return service.create(dto, postId);
    }
}
