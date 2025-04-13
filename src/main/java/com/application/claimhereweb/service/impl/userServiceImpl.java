package com.application.claimhereweb.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.claimhereweb.model.entity.user;
import com.application.claimhereweb.model.repository.userRepository;
import com.application.claimhereweb.service.IUserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class userServiceImpl implements IUserService {

    @Autowired
    private userRepository userRepository;

    @Override
    public List<user> getAllUserByRol() {
        List<user> resultados = userRepository.findUserByAdminEmpleado();
        return resultados;
    }
}
