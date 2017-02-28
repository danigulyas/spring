package com.dani.blog.domain.comment.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author dani
 */
@Data
@Getter
@Setter
public class CreateCommentRequest {

    @NotNull
    @Size(min = 1, max = 200)
    private String content;
}
