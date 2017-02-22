# Spring repo!

I wish it's spring already anyways.

A minimalistic blog application.

### Synopsys

1. In order to run, execute `mvn jetty:run`.
2. In order to test, run `mvn test`.

### Explanation

How it runs when `mvn jetty:run` executed:

1. Maven looks up the jetty plugin and executes "run"
    1. Added in pom.xml, see `<build><plugins>`
    2. It runs it with the `<configuration>` specififed there
    3. We use jetty for that, it's a Servlet container and web server
2. Jetty runs
    1. Since it implements Servlet 3.0 spec, it'll look for any classes implementing `javax.servlet .ServletContainerInitializer` in the classpath
    2. It'll find `com.dani.blog.BlogWebAppInitializer` (`org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer` implements it) which we extend 
3. `BlogWebAppInitializer` initializes
    1. The root context (for Spring) - `com.dani.blog.config.RootConfig`
    2. The servlet's context (for Jetty) - `com.dani.blog.config.WebConfig`
    3. Underlying that, Spring will create a DispatchServlet which will handle incoming requests
4. `@ComponentScan` in `RootConfig` and `WebConfig`
    1. Will scan components and registers them in the web / application context based on their annotations

