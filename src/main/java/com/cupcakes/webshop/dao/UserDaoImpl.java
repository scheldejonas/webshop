package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jonasschelde on 12/09/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAll() {

        Session session = sessionFactory.openSession();

        List<User> users = session.createCriteria(User.class).list();

        session.close();

        return users;
    }

    @Override
    public User findById(Long id) {

        Session session = sessionFactory.openSession();

        User user = session.get(User.class,id);
        Hibernate.initialize(user.getCarts());

        session.close();

        return user;
    }

    @Override
    public void save(User user) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.saveOrUpdate(user);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(User user) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();

        session.close();
    }
}
