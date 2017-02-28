package com.dani.blog.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dani
 */
@NoArgsConstructor
@Data
@Getter
public class Post {
    private Long id;
    private String content;
}
