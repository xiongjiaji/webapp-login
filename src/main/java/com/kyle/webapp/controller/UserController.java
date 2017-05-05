package com.kyle.webapp.controller;

import com.kyle.webapp.dao.UserDAO;
import com.kyle.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xiong on 2017/4/26.
 */
@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/user")
    public void saveUser() {
        User user = new User();
        user.setUserName("Hello");
        userDAO.save(user);
    }
}
