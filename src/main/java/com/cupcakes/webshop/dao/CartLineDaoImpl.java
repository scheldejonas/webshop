package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.CartLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jonasschelde on 11/09/2016.
 */
@Repository
public class CartLineDaoImpl implements CartLineDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CartLine> findAll() {

        Session session = sessionFactory.openSession();

        List<CartLine> cartLines = session.createCriteria(CartLine.class).list();

        session.close();

        return cartLines;
    }

    @Override
    public CartLine findById(Long id) {

        Session session = sessionFactory.openSession();

        CartLine cartLine = session.get(CartLine.class,id);

        session.close();

        return cartLine;
    }

    @Override
    public void save(CartLine cartLine) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(cartLine);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(CartLine cartLine) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(cartLine);

        session.getTransaction().commit();

        session.close();
    }
}
