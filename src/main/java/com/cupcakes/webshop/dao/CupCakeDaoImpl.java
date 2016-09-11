package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.CupCake;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
@Repository
public class CupCakeDaoImpl implements CupCakeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CupCake> findAll() {

        Session session = sessionFactory.openSession();

        List<CupCake> cupCakes = session.createCriteria(CupCake.class).list();

        session.close();

        return cupCakes;
    }

    @Override
    public CupCake findById(Long id) {

        Session session = sessionFactory.openSession();

        CupCake cupCake = session.get(CupCake.class,id);

        session.close();

        return cupCake;
    }

    @Override
    public void save(CupCake cupCake) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(cupCake);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(CupCake cupCake) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(cupCake);

        session.getTransaction().commit();

        session.close();
    }
}
