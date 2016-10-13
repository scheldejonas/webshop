package com.cupcakes.webshop.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by scheldejonas on 10/09/16.
 */
@Configuration
@PropertySource("classpath:app.properties")
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
    @Bean(name = "dataSource")
    @Profile("dev")
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(env.getProperty("webshop.db.driver")); // Setting the driver for the database
        basicDataSource.setUrl(env.getProperty("webshop.db.url")); // Set database url
        basicDataSource.setUsername(env.getProperty("webshop.db.username")); // Set username to local h2 db
        basicDataSource.setPassword(env.getProperty("webshop.db.password")); // Set password to local h2 db

        return basicDataSource;
    }


    @Bean(name = "dataSource")
    @Profile("test")
    public DataSource testDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(env.getProperty("webshop.db.mysql.driver"));
        basicDataSource.setUrl(env.getProperty("webshop.db.mysql.url"));
        basicDataSource.setUsername(env.getProperty("webshop.db.mysql.username"));
        basicDataSource.setPassword(env.getProperty("webshop.db.mysql.password"));

        return basicDataSource;
    }

    @Bean(name = "dataSource")
    @Profile("prod")
    public DataSource prodDataSource() {
        return new JndiDataSourceLookup().getDataSource(env.getProperty("webshop.jndi"));
    }

    /*
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.implicit_naming_strategy", env.getProperty("hibernate.implicit_naming_strategy"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibetnate.hbm2dll.auto", env.getProperty("hibernate.hbm2dll.auto"));
        return properties;
    }
    */

}
