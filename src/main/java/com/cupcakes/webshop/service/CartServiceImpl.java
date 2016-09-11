package com.cupcakes.webshop.service;

import com.cupcakes.webshop.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
@Service
public class CartServiceImpl implements CartService {
    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart findById(Long id) {
        return null;
    }

    @Override
    public void save(Cart cart, MultipartFile multipartFile) {

    }

    @Override
    public void delete(Cart cart) {

    }
}
