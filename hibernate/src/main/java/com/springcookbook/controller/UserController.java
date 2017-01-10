package com.springcookbook.controller;

import com.springcookbook.dao.UserDao;
import com.springcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by davidronaldson on 09/01/2017.
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDAO;

    @RequestMapping("user_add")
    @ResponseBody
    public String userList() {
        User user = new User();
        user.setFirstName("Merlin");
        user.setAge(372);

        userDAO.add(user);

        return "User was successfully added";
    }

}
