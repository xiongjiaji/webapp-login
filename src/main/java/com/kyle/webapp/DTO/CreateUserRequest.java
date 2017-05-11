package com.kyle.webapp.DTO;

import com.kyle.webapp.entity.User;

/**
 * Created by Xiong on 2017/5/11.
 */
public class CreateUserRequest {

    private String identifier;
    private String password;
    private String identityType;
    private User user;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
