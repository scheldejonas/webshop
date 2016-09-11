package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.CartLine;

import java.util.List;

/**
 * Created by jonasschelde on 11/09/2016.
 */
public interface CartLineDao {
    List<CartLine> findAll();
    CartLine findById(Long id);
    void save(CartLine cartLine);
    void delete(CartLine cartLine);
}
