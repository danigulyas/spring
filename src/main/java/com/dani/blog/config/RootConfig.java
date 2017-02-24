package com.dani.blog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configures beans used in the application context created by Spring, doesn't scan {@link WebConfig}.
 * @author dani
 */
@Configuration
@ComponentScan(basePackages = {"com.dani.blog"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
