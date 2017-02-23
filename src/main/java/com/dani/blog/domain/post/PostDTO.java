package com.dani.blog.domain.post;

import com.dani.blog.domain.Post;
import lombok.Data;

/**
 * @author dani
 */
@Data
public class PostDTO implements Post {
    private final Long id;
    private final String name;
    private final String content;
}
