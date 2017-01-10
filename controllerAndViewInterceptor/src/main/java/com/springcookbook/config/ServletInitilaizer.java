package com.springcookbook.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by davidronaldson on 08/12/2016.
 */
public class ServletInitilaizer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class<?>[0];
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[]{AppConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }
}
