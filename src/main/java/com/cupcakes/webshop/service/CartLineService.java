package com.cupcakes.webshop.service;

import com.cupcakes.webshop.model.CartLine;
import com.cupcakes.webshop.model.CupCake;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
public interface CartLineService {
    List<CartLine> findAll();
    CartLine findById(Long id);
    void save(CartLine cartLine, CupCake cupCake);
    void delete(CartLine cartLine);
}