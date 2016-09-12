package com.cupcakes.webshop.service;

import com.cupcakes.webshop.model.Cart;
import com.cupcakes.webshop.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
public interface CartService {
    List<Cart> findAll();
    Cart findById(Long id);
    void save(Cart cart, User user);
    void delete(Cart cart);
}
