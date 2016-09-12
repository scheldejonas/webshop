package com.cupcakes.webshop.model;

import javax.persistence.*;

/**
 * Created by scheldejonas on 11/09/16.
 */
@Entity
public class CartLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL)
    private CupCake cupCake;

    // Additional fields
    private int quantity;
    private int sumPrice;

    public CartLine() {
    }

    public CartLine(Cart cart, CupCake cupCake, int quantity, int sumPrice) {
        this.cart = cart;
        this.cupCake = cupCake;
        this.quantity = quantity;
        this.sumPrice = sumPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CupCake getCupCake() {
        return cupCake;
    }

    public void setCupCake(CupCake cupCake) {
        this.cupCake = cupCake;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
}
