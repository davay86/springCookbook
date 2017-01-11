package com.springcookbook.controller;

import com.springcookbook.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidronaldson on 10/01/2017.
 */

@Controller
public class UserController {

    @RequestMapping("/user_list")
    public void userList() {
    }

    @RequestMapping("addUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute("defaultUser") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        } else {
            System.out.println(user.getFirstname());
            System.out.println(user.getCountry());
            System.out.println(user.isMarried());
            return "redirect:/user_list";
        }
    }

    @ModelAttribute("defaultUser")
    public User defaultUser() {
        return new User("TestUser", 36, "ca", true);
    }

    @ModelAttribute("countries")
    public Map<String, String> countries() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("us", "United States");
        m.put("ca", "Canada");
        m.put("fr", "France");
        m.put("de", "Germany");
        return m;
    }
}
