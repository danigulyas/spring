package com.dani.blog.domain.post;

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
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @Column
    @NotNull
    @Size(min = 1, max = 500000)
    private String content;

    public PostEntity(String name, String content) {
        this.id = null;
        this.name = name;
        this.content = content;
    }
}
