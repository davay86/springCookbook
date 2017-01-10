package com.springcookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by davidronaldson on 03/12/2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public String userList() {
        return "my_friends";
    }

    @RequestMapping("/add")
    public String addUser(Model model){
        model.addAttribute("pageHit", "add");
        return "my_friends";
    }
}
