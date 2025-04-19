package com.application.claimhereweb.service;

import java.util.List;

import com.application.claimhereweb.model.entity.User;
import com.application.claimhereweb.model.entity.enumEntity.RoleName;
import com.application.claimhereweb.service.dto.ResponseUserDTO;
import com.application.claimhereweb.service.dto.SaveUserDTO;

public interface IUserService {

    List<ResponseUserDTO> findAll();

    List<User> getAllUserByRol();

    ResponseUserDTO saveCustomer(SaveUserDTO user);

    ResponseUserDTO saveByAdmin(SaveUserDTO user, RoleName role);

    boolean existsByUsername(String email);
}
