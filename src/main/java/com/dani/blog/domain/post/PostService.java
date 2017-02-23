package com.dani.blog.domain.post;

import com.dani.blog.data.PostRepository;
import com.dani.blog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dani
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // Create a constructor and annotate it with @Autowired.
public class PostService {
    private final PostRepository repository;

    public Post create(String name, String content) {
        PostEntity entity = repository.save(new PostEntity(name, content));
        return new PostDTO(0L, "a", "b");
    }

    public List<Post> getAll() {
        return repository.findAll().stream().map(this::entityToPost).collect(Collectors.toList());
    }

    private Post entityToPost(PostEntity entity) {
        return new PostDTO(entity.getId(), entity.getName(), entity.getContent());
    }
}
