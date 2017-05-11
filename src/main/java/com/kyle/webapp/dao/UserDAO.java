package com.kyle.webapp.dao;

import com.kyle.webapp.entity.User;

/**
 * Created by Xiong on 2017/5/2.
 */
public interface UserDAO {

    User save(User user);

    void delete(long id);

    void update(User user);

    User get(long id);

    User get(String userName);

}
