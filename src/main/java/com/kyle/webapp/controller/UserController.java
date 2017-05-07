package com.kyle.webapp.controller;

import com.kyle.webapp.dao.UserDAO;
import com.kyle.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Xiong on 2017/4/26.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public User getUser(@PathVariable long userId) {
        User user = userDAO.get(userId);
        if (user != null) {
            return user;
        } else {
            throw new NullPointerException("user is null!");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userDAO.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        if (null == userDAO.get(Long.valueOf(user.getId()))) {
            throw new NullPointerException("user doesn't exist!");
        } else {
            userDAO.update(user);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userDAO.delete(userId);
    }

}
