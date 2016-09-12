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

        List<CartLine> cartLines = cartLineDao.findAll();

        // If Cart Line with CupCake and Cart already exist, then update quantity and sum price
        boolean isInDB = false;

        for (CartLine cartLineTemp : cartLines) {
            if (cupCakeId == (long)cartLineTemp.getCupCake().getId()) {

                // TODO: BEFORE Changing cartline | check also same cart to present cart instead of Jonas Cart, after User Authentication is working

                // Update existing Cart Line for the Cart with quantity and price | Update cart_id, no need
                cartLineTemp.setQuantity( cartLineTemp.getQuantity() + cartLine.getQuantity() );
                cartLineTemp.setSumPrice( cartLineTemp.getQuantity() * cartLineTemp.getCupCake().getPrice() );

                cartLine = cartLineTemp;

                // Saving cart line data
                cartLineDao.save(cartLineTemp);

                // Check for  that Cart Line was existing in Cart
                isInDB = true;
            }
        }

        // If Cartline with cupCake exist in DB, then update cart with cartline and totalprice

        /*
        if (isInDB) {
            Cart cart = cartService.findById( cartLine.getCart().getId() );

            for ( CartLine cartLineTempCart : cart.getCartLines() ) {
                if (cartLineTempCart.getId() == cartLine.getId()) {
                    cart.getCartLines()
                }
            };
        }
        */
        /*
        else {
            // Get the requested Cup Cake
            CupCake cupCake = cupCakeService.findById(cupCakeId);

            // Save the cup cake to the Cart Line
            cartLine.setCupCake(cupCake);


            // Calculating the sum price of the cart line
            cartLine.setSumPrice(cupCake.getPrice() * cartLine.getQuantity());

            // Create a new Cart and storing for later use in Cart Line Table
            if (cartService.findAll().size() < 1) {
                // TODO: remove this when authentication is built an tested working
                Cart cart = new Cart();

                // TODO: make user authentication operate here with UserServiceImpl, in future
                cartService.save(cart, new User("Jonas Schelde", "welcome", 800, cart));
                // TODO: if cart exist, then add to that instead of new

            }
            List<Cart> carts = cartService.findAll();

            // Ready the cart for storing with the existing cartline
            Cart newCart = cartService.findById(carts.get(carts.size() - 1).getId());
            newCart.getCartLines().add(cartLine);
            cartLine.setCart(newCart);

            // Send the Cart Line to the data access object for storing in database
            cartLineDao.save(cartLine);

            // Update the cart with connection to the new Cart Line in DB
            cartService.save(newCart, newCart.getUser());
            // TODO: change user to logged in user, when authentication is created and tested
        }
        */
    }

    @Override
    public void delete(CartLine cartLine) {

        // TODO:Make checks before it is possible to delete
        cartLineDao.delete(cartLine);
    }
}
