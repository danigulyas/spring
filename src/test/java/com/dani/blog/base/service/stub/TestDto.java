package com.dani.blog.base.service.stub;

import lombok.*;

import java.io.Serializable;

/**
 * @author dani
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TestDto implements Serializable {
    private Long id;
    private String test;
}