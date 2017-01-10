package com.springcookbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by davidronaldson on 02/12/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springcookbook.*")
public class AppConfig {

}
