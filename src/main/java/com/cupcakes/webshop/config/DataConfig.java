package com.cupcakes.webshop.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by scheldejonas on 10/09/16.
 */
@Configuration
@PropertySource("app.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(config);
        sessionFactory.setPackagesToScan(env.getProperty("webshop.entity.package"));
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();

        // Setting the driver for the database
        basicDataSource.setDriverClassName(env.getProperty("webshop.db.driver"));

        // Set database url
        basicDataSource.setUrl(env.getProperty("webshop.db.url"));

        // Set username and password to db
        basicDataSource.setUsername(env.getProperty("webshop.db.username"));
        basicDataSource.setPassword(env.getProperty("webshop.db.password"));

        return basicDataSource;
    }

}
