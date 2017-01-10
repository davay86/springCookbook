package com.springcookbook.main;

import com.springcookbook.config.AppConfig;
import com.springcookbook.config.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by davidronaldson on 02/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class);

        User admin = (User) springContext.getBean("admin");

        System.out.println("admin name: " + admin.getName());
        System.out.println("admin skill: " + admin.getSkill());

        User admin2 = (User) springContext.getBean("admin");

        System.out.println("admin name: " + admin2.getName());
        System.out.println("admin skill: " + admin2.getSkill());


        springContext.close();
    }

}
