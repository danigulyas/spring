package com.dani.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configures beans used in the DispatcherServlet's application context.
 * @author dani
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.dani.blog.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Creating the bean of the view resolver (locating template files for the template engine in resources).
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);

        return resolver;
    }

    /**
     * Static content handling, if this wouldn't be configured DispatcherServlet
     * would handle the requests for static files as well, with this enabled
     * it'll forward the requests for static resources to Tomcat's default servlet.
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
