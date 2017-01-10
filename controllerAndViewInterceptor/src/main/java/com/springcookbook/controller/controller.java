package com.springcookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by davidronaldson on 08/12/2016.
 */
@Controller
public class controller {

    @RequestMapping("/user_list")
    public void userList() {
        System.out.println("UserController.userList()");
    }
}
