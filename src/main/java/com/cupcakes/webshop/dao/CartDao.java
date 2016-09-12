package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.Cart;
import com.cupcakes.webshop.model.User;

import java.util.List;

/**
 * Created by jonasschelde on 12/09/2016.
 */
public interface CartDao {
    List<Cart> findAll();
    Cart findById(Long id);
    void save(Cart cart);
    void delete(Cart cart);
}
