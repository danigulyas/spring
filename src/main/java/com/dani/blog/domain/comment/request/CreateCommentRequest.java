package com.dani.blog.domain.comment.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dani
 */
@Data
@Getter
@Setter
public class CreateCommentRequest {
    private String content;
    private long postId;
}
