package com.dani.blog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configures beans used in the DispatcherServlet's application context.
 * @author dani
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.dani.blog.web")
public class WebConfig extends WebMvcConfigurerAdapter {
}
