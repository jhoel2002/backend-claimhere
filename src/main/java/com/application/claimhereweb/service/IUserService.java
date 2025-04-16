package com.application.claimhereweb.service;

import java.util.List;

import com.application.claimhereweb.model.entity.User;

public interface IUserService {

    public List<User> findAll();

    List<User> getAllUserByRol();

    User save(User user);

    boolean existsByUsername(String email);
}
