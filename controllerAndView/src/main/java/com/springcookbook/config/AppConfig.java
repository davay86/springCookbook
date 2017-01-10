package com.springcookbook.config;

import com.springcookbook.controller.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created by davidronaldson on 03/12/2016.
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.springcookbook.controller")
public class AppConfig extends WebMvcConfigurerAdapter{

    @Bean
    public HandlerInterceptor performanceInterceptor(){
        PerformanceInterceptor interceptor;
        interceptor = new PerformanceInterceptor();
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(performanceInterceptor()).addPathPatterns("/home", "/user/*");
    }

//    // declare Tiles configuration file
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        final String[] definitions = { "/WEB-INF/tiles.xml" };
//        tilesConfigurer.setDefinitions(definitions);
//        return tilesConfigurer;
//    }
//
//    // declare Tiles as a view resolver
//    @Bean
//    public ViewResolver tilesViewResolver() {
//        TilesViewResolver resolver = new TilesViewResolver();
//        return resolver;
//    }

}
