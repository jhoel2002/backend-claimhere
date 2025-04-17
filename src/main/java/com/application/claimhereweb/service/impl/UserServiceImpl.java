package com.application.claimhereweb.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.claimhereweb.model.entity.Role;
import com.application.claimhereweb.model.entity.User;
import com.application.claimhereweb.model.repository.UserRepository;
import com.application.claimhereweb.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> getAllUserByRol() {
        List<User> resultados = userRepository.findUserByAdminEmpleado();
        return resultados;
    }

    @Override
    @Transactional
    public User save(User user) {

        Set<Role> roles = new HashSet<>();

        roles.add(Role.ROLE_USER);

        if (user.isAdmin()) {
            roles.add(Role.ROLE_ADMIN);
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String email) {
        return userRepository.existsByEmail(email);
    }
}
