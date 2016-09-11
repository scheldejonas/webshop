package com.cupcakes.webshop.service;

import com.cupcakes.webshop.dao.CartLineDao;
import com.cupcakes.webshop.model.Cart;
import com.cupcakes.webshop.model.CartLine;
import com.cupcakes.webshop.model.CupCake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonasschelde on 11/09/2016.
 */
@Service
public class CartLineServiceImpl implements  CartLineService {

    @Autowired
    private CartLineDao cartLineDao;

    @Override
    public List<CartLine> findAll() {
        return cartLineDao.findAll();
    }

    @Override
    public CartLine findById(Long id) {
        return cartLineDao.findById(id);
    }

    @Override
    public void save(CartLine cartLine, CupCake cupCake) {

        // Save the cup cake to the Cart Line
        cartLine.setCupCake(cupCake);

        // Calculating the sum price of the cart line
        cartLine.setSumPrice(cupCake.getPrice()*cartLine.getQuantity());

        // Create a new Cart
        cartLine.setCart(new Cart());
        // TODO: if cart exist, then add to that instead of new

        // Send the Cart Line to the data acces object for storing in database
        cartLineDao.save(cartLine);
    }

    @Override
    public void delete(CartLine cartLine) {

        // TODO:Make checks before it is possible to delete
        cartLineDao.delete(cartLine);
    }
}
