package com.kyle.webapp.dao.impl;

import com.kyle.webapp.dao.IdentityDAO;
import com.kyle.webapp.entity.Identity;
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
public class IdentityDAOImpl implements IdentityDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Identity identity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(identity);
    }

    @Override
    public void delete(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Identity identity = (Identity) currentSession.createCriteria(Identity.class)
                .add(Restrictions.idEq(String.valueOf(id)))
                .uniqueResult();
        if (null != identity) {
            currentSession.delete(identity);
        }
    }

    @Override
    public void update(Identity identity) {
        save(identity);
    }

    @Override
    public Identity get(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (Identity) currentSession.createCriteria(Identity.class)
                .add(Restrictions.idEq(String.valueOf(id)))
                .uniqueResult();
    }

    @Override
    public Identity getbyUserId(long userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (Identity) currentSession.createCriteria(Identity.class)
                .add(Restrictions.eq("userId", String.valueOf(userId)))
                .uniqueResult();
    }

}
