package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.Cart;
import com.cupcakes.webshop.model.CartLine;
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
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Cart> findAll() {

        Session session = sessionFactory.openSession();

        List<Cart> carts = session.createCriteria(Cart.class).list();

        session.close();

        return carts;
    }

    @Override
    public Cart findById(Long id) {

        Session session = sessionFactory.openSession();

        Cart cart = session.get(Cart.class,id);
        System.out.println(cart.toString());
        // getting all cartLines for it to be available when saving new Cartlines and editing.
        Hibernate.initialize(cart.getCartLines());

        session.close();

        return cart;
    }

    @Override
    public void save(Cart cart) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.saveOrUpdate(cart);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(Cart cart) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(cart);

        session.getTransaction().commit();

        session.close();
    }
}
