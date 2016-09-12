package com.cupcakes.webshop.service;

import com.cupcakes.webshop.dao.CartDao;
import com.cupcakes.webshop.model.Cart;
import com.cupcakes.webshop.model.CartLine;
import com.cupcakes.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return cartDao.findById(id);
    }

    @Override
    public void save(Cart cart, User user) {
        cart.setUser(user);
        int newTotalPrice = 0;
        for (CartLine cartLine : cart.getCartLines()) {
            newTotalPrice += cartLine.getSumPrice();
        }
        cart.setTotalPrice(newTotalPrice);
        cartDao.save(cart);
    }

    @Override
    public void delete(Cart cart) {
        cartDao.delete(cart);
    }
}
