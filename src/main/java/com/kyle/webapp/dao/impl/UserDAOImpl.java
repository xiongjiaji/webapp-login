package com.kyle.webapp.dao.impl;

import com.kyle.webapp.dao.UserDAO;
import com.kyle.webapp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Xiong on 2017/5/2.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = (User)currentSession.createCriteria(User.class)
                .add(Restrictions.idEq(id))
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
    public List<User> get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<User> users = currentSession.createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .list();
        return users;
    }

}
