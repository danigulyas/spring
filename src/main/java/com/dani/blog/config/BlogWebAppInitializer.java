package com.dani.blog.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Configuration alternative to web.xml.
 *
 * Works with ServletContainerInitializer (introduced in Servlet 3.0 at 2009).
 * @author dani
 */
public class BlogWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * Beans created by the returned  {@link org.springframework.context.annotation.Configuration} classes
     * will be put into the DispatcherServlet's application context.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * Beans created by the returned {@link org.springframework.context.annotation.Configuration} classes
     * will be put into the application context created by Spring.
     * @see org.springframework.web.context.ContextLoaderListener
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }
}
