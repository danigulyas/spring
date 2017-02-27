package com.dani.blog.web;

import com.dani.blog.domain.Comment;
import com.dani.blog.domain.comment.CommentService;
import com.dani.blog.web.dto.CreateCommentDto;
import com.dani.blog.web.support.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
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

    @PostMapping
    public Comment create(@Valid CreateCommentDto dto) {
        //TODO: make service receive CreateCommentDto then pass it to service
    }

    /**
     * TODO: add create, delete POST /posts/{id}/comments/, DELETE /posts/{id}/comments/{commentId}
     */
}
