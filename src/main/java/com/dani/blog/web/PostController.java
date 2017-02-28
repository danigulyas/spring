package com.dani.blog.web;

import com.dani.blog.domain.Post;
import com.dani.blog.domain.post.PostService;
import com.dani.blog.domain.post.request.CreatePostRequest;
import com.dani.blog.web.support.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * @author dani
 */
@RestController
@RequestMapping("/posts")
@AllArgsConstructor(onConstructor = @__(@Inject))
public class PostController {
    private final PostService service;

    @GetMapping
    public List<Post> getAll() {
        List<Post> posts = service.findAll();
        if(posts.size() == 0) throw new EntityNotFoundException();

        return posts;
    }

    @GetMapping(path = "/{id}")
    public Post getById(@PathVariable long id) {
        Post post = service.find(id);
        if(post == null) throw new EntityNotFoundException();

        return service.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@Valid @RequestBody CreatePostRequest request) {
        return service.create(request);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
