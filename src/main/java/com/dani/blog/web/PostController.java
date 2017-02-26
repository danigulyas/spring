package com.dani.blog.web;

import com.dani.blog.domain.Post;
import com.dani.blog.domain.post.PostService;
import com.dani.blog.web.support.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
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
    public Post getById(@PathVariable("id") long id) {
        Post post = service.find(id);
        if(post == null) throw new EntityNotFoundException();

        return service.find(id);
    }

    /**
     * TODO: add create, delete
     */
}
