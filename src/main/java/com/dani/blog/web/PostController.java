package com.dani.blog.web;

import com.dani.blog.domain.Post;
import com.dani.blog.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author dani
 */
@RestController
@RequestMapping(path = "/post/")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PostController {
    private final PostService service;

    @RequestMapping(path = "/", method = GET)
    public List<Post> findAll() {
        List<Post> posts = service.getAll();

        if (posts.isEmpty()) {
            throw new NotFoundException();
        }

        return posts;
    }
}
