package com.dani.blog.web;

import com.dani.blog.domain.Comment;
import com.dani.blog.domain.comment.CommentService;
import com.dani.blog.web.support.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * @author dani
 */
@RestController
@RequestMapping("/post/{postId}/comments")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CommentController {
    private final CommentService service;

    @GetMapping
    public List<Comment> getAll(@PathVariable("postId") long postId) {
        try {
            final List<Comment> comments = service.findAllByPostId(postId);
            if(comments == null) throw new EntityNotFoundException();

            return comments;
        } catch(IllegalStateException ise) {
            throw new EntityNotFoundException();
        } catch(EntityNotFoundException nfe) {
            throw nfe;
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
     * TODO: add create, delete POST /posts/{id}/comments/, DELETE /posts/{id}/comments/{commentId}
     */
}
