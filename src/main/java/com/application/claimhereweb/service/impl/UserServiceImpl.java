package com.application.claimhereweb.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.claimhereweb.model.entity.Role;
import com.application.claimhereweb.model.entity.User;
import com.application.claimhereweb.model.repository.RoleRepository;
import com.application.claimhereweb.model.repository.UserRepository;
import com.application.claimhereweb.service.IUserService;

import static com.application.claimhereweb.utils.constants.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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

        Optional<Role> optionalRoleUser = roleRepository.findByName(CUSTOMER);
        Set<Role> roles = new HashSet<>();

        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByName(ADMIN);
            optionalRoleAdmin.ifPresent(roles::add);
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
