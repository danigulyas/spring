package com.dani.blog.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author dani
 */
@Data
@NoArgsConstructor
public class CreateCommentDto {

    @NotNull
    private String content;

    @NotNull
    private long postId;
}
