package com.dani.blog.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author dani
 */
@NoArgsConstructor
@Data
@Getter
public class Comment {
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String content;

    @NotNull
    private Post post;
}
