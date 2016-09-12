package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.User;

import java.util.List;

/**
 * Created by jonasschelde on 12/09/2016.
 */
public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(User user);
}
