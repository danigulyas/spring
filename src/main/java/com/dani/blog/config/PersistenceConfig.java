package com.dani.blog.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Configuration for the persistence layer.
 *
 * {@link EnableJpaRepositories} means that Spring Data will generate implementation for classes extending
 * {@link org.springframework.data.jpa.repository.JpaRepository} in the base package (doesn't look recursively!).
 *
 * How persistence works is:
 * 1) We configure a data source
 *  A data source is basically an interface we can tell to "hey, give me a connection!", we use Apache's DBCP
 *  (data-base connection pool), which pools the connections, this is usually used in production, see c3p0.
 * 2) We configure a JpaVendorAdapter
 *  This is Spring Data's adapter ot a given JPA provider (in this case Hibernate), we can configure
 *  implementation-details here (for example "hbm2dll.auto"), with this Spring can talk to the JPA implementation.
 * 3) We configure an EntityManagerFactory
 *  This is basically a wrapped form of the JPA Vendor's {@link javax.persistence.EntityManagerFactory} implementation,
 *  it'll click into Spring's Transaction handling and PersistenceContext, it'll always give the right EntityManager.
 * 4) We annotate with {@link EnableJpaRepositories}
 *  This says: search the "basePackages" (only the base package, not the child packages) for classes annotated with
 *  {@link javax.persistence.Entity} and add them to the persistence context.
 *
 * @author dani
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.dani.blog.data")
public class PersistenceConfig {

    /**
     * Data source, manages pooling of connections, creds, etc.
     * @return
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/blog_spring");
        ds.setUsername("root");
        ds.setPassword("toor");

        return ds;
    }

    /**
     * Adapter for a JPA provider, we'll use Hibernate.
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect"); // Dialect.
        adapter.setDatabase(Database.MYSQL); // Database.
        adapter.setGenerateDdl(true); // Auto-generate database schema.
        adapter.setShowSql(true); // Print SQL to the command line.

        return adapter;
    }

    /**
     * Spring's EntityManagerFactory implementation, naming is important, if it's not "entityManagerFactory"
     * the ORM can't get it autowired.
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource ds, JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("com.dani.blog.domain");

        return emf;
    }
}
