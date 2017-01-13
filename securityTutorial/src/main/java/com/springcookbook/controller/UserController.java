package com.springcookbook.controller;

import com.springcookbook.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by davidronaldson on 11/01/2017.
 */

@Controller
public class UserController {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("/user_list")
    public void userList() {
    }

    @RequestMapping("addUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value="addUser", method= RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        System.out.println(user.getName());
        System.out.println(user.isMarried());
        return "redirect:/user_list";
    }

    @ModelAttribute("defaultUser")
    public User defaultUser() {
        User user = new User();
        user.setName("Joe");
        user.setMarried(true);
        return user;
    }
}
