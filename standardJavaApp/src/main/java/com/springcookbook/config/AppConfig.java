package com.springcookbook.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * Created by davidronaldson on 02/12/2016.
 */
@Configuration
public class AppConfig {

    int counter =1;

    @Bean
    public User admin(){
        User u = new User();
        u.setName("Merlin");
        u.setSkill("Magic counter " + counter);
        counter ++;
        return u;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        return dataSource;
    }

}
