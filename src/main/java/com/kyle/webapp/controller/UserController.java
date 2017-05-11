package com.kyle.webapp.controller;

import com.kyle.webapp.DTO.CreateUserRequest;
import com.kyle.webapp.dao.IdentityDAO;
import com.kyle.webapp.dao.UserDAO;
import com.kyle.webapp.entity.Identity;
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

    @Autowired
    private IdentityDAO identityDAO;

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

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void registerUser(@RequestBody CreateUserRequest createUserRequest) {
        if (createUserRequest != null) {
            User user = userDAO.save(createUserRequest.getUser());
            Identity identity = new Identity();
            identity.setUserId(user.getId());
            identity.setIdentityType(createUserRequest.getIdentityType());
            identity.setIdentifier(createUserRequest.getIdentifier());
            identity.setCredential(createUserRequest.getPassword());
            identityDAO.save(identity);
        } else {
            throw new NullPointerException("createUserRequest is null!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public void loginUser(@RequestBody CreateUserRequest loginUserRequest) {
        User user = userDAO.get(loginUserRequest.getIdentifier());
        if (loginUserRequest.getPassword().equals(identityDAO.getbyUserId(Long.valueOf(user.getId())).getCredential())) {

        } else {
            throw new RuntimeException();
        }
    }

}
