package com.springcookbook.controller;

import com.springcookbook.dao.UserDAO;
import com.springcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by davidronaldson on 09/12/2016.
 */

@Controller
public class userController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("user_list")
    @ResponseBody
    public String userList() {
        User user = userDAO.findById(117L);
        System.out.println("UserController.userList()");
        user.setAge(3400);
        userDAO.update(user);
        return "Possibly worked";
        //return userDAO.findById(100L).getFirstName();
    }
}
