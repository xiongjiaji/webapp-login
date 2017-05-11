package com.kyle.webapp.dao.impl;

import com.kyle.webapp.dao.UserDAO;
import com.kyle.webapp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Xiong on 2017/5/2.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
        return user;
    }

    @Override
    public void delete(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = (User) currentSession.createCriteria(User.class)
                .add(Restrictions.idEq(String.valueOf(id)))
                .uniqueResult();
        if (null != user) {
            currentSession.delete(user);
        }
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    @SuppressWarnings(value = {"unchecked"})
    public User get(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (User) currentSession.createCriteria(User.class)
                .add(Restrictions.idEq(String.valueOf(id)))
                .uniqueResult();
    }

    @Override
    @SuppressWarnings(value = {"unchecked"})
    public User get(String userName) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (User) currentSession.createCriteria(User.class)
                .add(Restrictions.eq("userName", String.valueOf(userName)))
                .uniqueResult();
    }

}
