package com.celo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Declares beans using @Bean annotation
 */
@Configuration
@ComponentScan(basePackages = "com.celo")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DriverManagerDataSource datasource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:postgresql://localhost:5432/spring_revisit");
        datasource.setDriverClassName("org.postgresql.Driver");
        datasource.setUsername("postgres");
        datasource.setPassword("celokuhle");
        return datasource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean ();
        sessionFactoryBean.setDataSource(datasource());
        sessionFactoryBean.setPackagesToScan("com.celo.annotations_based_wiring.model");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(sessionFactory().getObject());
//        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return props;
    }

//    @Bean
//    public Customer customer() {
//        return new Customer();
//    }

//    @Bean
//    /**
//     * used to provide specifics about the particular JPA implementation to use.
//     *
//     * Spring comes with a handful of JPA vendor adaptor to choose from:
//          EclipseLinkJpaVendorAdapter
//          HibernateJpaVendorAdapter
//          OpenJpaVendorAdapter
//          TopLinkJpaVendorAdapter
//     */
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter jpaVendorAdapter = new  HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
//        jpaVendorAdapter.setShowSql(true); // via hibernate properties :- hibernateProps.put("hibernate.show_sql", true)
//        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect"); //via hibernate properties :- props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
//        return jpaVendorAdapter;
//    }

}
