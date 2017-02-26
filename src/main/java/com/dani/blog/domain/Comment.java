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
public class Comment {
    private long id;
    private String content;
    private Post post;
}
