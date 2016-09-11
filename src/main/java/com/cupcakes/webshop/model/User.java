package com.cupcakes.webshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scheldejonas on 10/09/16.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private int balance;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();

    public User() {
    }

    public User(Long id, String username, String password, int balance, List<Cart> carts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carts = carts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
