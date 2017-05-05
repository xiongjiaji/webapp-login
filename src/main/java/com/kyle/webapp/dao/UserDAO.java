package com.kyle.webapp.dao;

import com.kyle.webapp.entity.User;

import java.util.List;

/**
 * Created by Xiong on 2017/5/2.
 */
public interface UserDAO {

    void save(User user);

    void delete(int id);

    void update(User user);

    List<User> get(int id);

}
