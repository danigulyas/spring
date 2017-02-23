package com.dani.blog.domain;

import javax.persistence.*;

/**
 * @author dani
 */
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String content;

    public Post(String name, String content) {
        this.id = null;
        this.name = name;
        this.content = content;
    }
}
