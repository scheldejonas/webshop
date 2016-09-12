package com.cupcakes.webshop.service;

import com.cupcakes.webshop.dao.CartLineDao;
import com.cupcakes.webshop.model.Cart;
import com.cupcakes.webshop.model.CartLine;
import com.cupcakes.webshop.model.CupCake;
import com.cupcakes.webshop.model.User;
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

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CupCakeService cupCakeService;

    @Override
    public List<CartLine> findAll() {
        return cartLineDao.findAll();
    }

    @Override
    public CartLine findById(Long id) {
        return cartLineDao.findById(id);
    }

    @Override
    public void save(CartLine cartLine, Long cupCakeId) {

        // Get the requested Cup Cake
        CupCake cupCake = cupCakeService.findById(cupCakeId);

        // Save the cup cake to the Cart Line
        cartLine.setCupCake(cupCake);

        // Upgrade cart line number
        List<CartLine> cartLines = cartLineDao.findAll();
        cartLine.setId( cartLineDao.findById( cartLines.get(cartLines.size()).getId() ) );

        // Calculating the sum price of the cart line
        cartLine.setSumPrice(cupCake.getPrice()*cartLine.getQuantity());

        // Create a new Cart and storing for later use in Cart Line Table
        if (cartService.findAll().size() < 1) {
        // TODO: remove this when authentication is built an tested working
            Cart cart = new Cart();

            // TODO: make user authentication operate here with UserServiceImpl, in future
            cartService.save(cart, new User("Jonas Schelde", "welcome", 800, cart) );
            // TODO: if cart exist, then add to that instead of new

        }
        List<Cart> carts = cartService.findAll();
        System.out.println( cartService.findById( carts.get(carts.size()-1).getId() ) );

        // Ready the cart for storing with the existing cartline
        Cart newCart = cartService.findById( carts.get(carts.size()-1).getId() );
        newCart.getCartLines().add(cartLine);
        cartLine.setCart(newCart);

        // Send the Cart Line to the data access object for storing in database
        cartLineDao.save(cartLine);

        // Update the cart with connection to the new Cart Line in DB
        cartService.save(newCart,newCart.getUser());
        // TODO: change user to logged in user, when authentication is created and tested
    }

    @Override
    public void delete(CartLine cartLine) {

        // TODO:Make checks before it is possible to delete
        cartLineDao.delete(cartLine);
    }
}
