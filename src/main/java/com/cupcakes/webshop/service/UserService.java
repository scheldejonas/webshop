package com.cupcakes.webshop.service;

import com.cupcakes.webshop.model.User;

import java.util.List;

/**
 * Created by jonasschelde on 12/09/2016.
 */
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(User user);
}
