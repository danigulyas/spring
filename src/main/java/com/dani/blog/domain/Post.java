package com.dani.blog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dani
 */
@NoArgsConstructor
@Getter
@Setter
public class Post {
    private Long id;
    private String name;
    private String content;
}
