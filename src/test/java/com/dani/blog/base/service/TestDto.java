package com.dani.blog.base.service;

import lombok.*;

/**
 * @author dani
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TestDto {
    private Long id;
    private String test;
}