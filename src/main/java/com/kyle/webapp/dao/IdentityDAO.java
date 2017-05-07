package com.kyle.webapp.dao;

import com.kyle.webapp.entity.Identity;

/**
 * Created by Xiong on 2017/5/2.
 */
public interface IdentityDAO {

    void save(Identity user);

    void delete(long id);

    void update(Identity user);

    Identity get(long id);

}
