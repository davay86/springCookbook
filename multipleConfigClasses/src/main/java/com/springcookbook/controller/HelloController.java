package com.springcookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by davidronaldson on 02/12/2016.
 */
@Controller
public class HelloController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("hi")
    @ResponseBody
    public String hi(){
        return "Hello World";
    }

    @RequestMapping("whichBeans")
    @ResponseBody
    public String whichBeansAvailable(){
        String beansAvailable = "Beans in system: ";
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            beansAvailable = beansAvailable + bean + ", ";
        }
        return beansAvailable;
    }
}
