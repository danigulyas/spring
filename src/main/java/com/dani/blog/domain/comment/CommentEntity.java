package com.dani.blog.domain.comment;

import com.dani.blog.domain.Post;
import com.dani.blog.domain.post.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author dani
 */
@Entity
@Data
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String content;

    @OneToOne(targetEntity = PostEntity.class, fetch = FetchType.LAZY)
    @NotNull
    private PostEntity post;
}
