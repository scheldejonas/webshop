package com.cupcakes.webshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scheldejonas on 10/09/16.
 */
@Entity
public class CupCake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Topping topping = new Topping();

    @OneToOne(cascade = CascadeType.ALL)
    private Bottom bottom = new Bottom();

    @OneToMany(mappedBy = "cupCake", cascade = CascadeType.ALL)
    private List<CartLine> cartLines = new ArrayList<>();
    private int price;
    private String hash;

    public CupCake() {
    }

    public CupCake(Topping topping, Bottom bottom, List<CartLine> cartLines, int price, String hash) {
        this.topping = topping;
        this.bottom = bottom;
        this.cartLines = cartLines;
        this.price = price;
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
