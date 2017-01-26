package com.springcookbook.config;

import com.springcookbook.batch.BatchConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by davidronaldson on 26/01/2017.
 */
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
