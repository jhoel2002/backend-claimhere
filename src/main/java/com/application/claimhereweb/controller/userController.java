package com.application.claimhereweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.claimhereweb.model.entity.enumEntity.RoleName;
import com.application.claimhereweb.service.dto.ResponseUserDTO;
import com.application.claimhereweb.service.dto.SaveUserDTO;
import com.application.claimhereweb.service.impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200", originPatterns = "*")
@RequestMapping("api/users")
public class userController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<ResponseUserDTO> listAll() {
        return userService.findAll();
    }

    @PostMapping("/register/{role}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody SaveUserDTO user, @PathVariable RoleName role) {
        // if (result.hasFieldErrors()) {
        //     return validation(result);
        // }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user,role));
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> createByAdmin(@Valid @RequestBody SaveUserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveByAdmin(user));
    }

    // private ResponseEntity<?> validation(BindingResult result) {
    //     Map<String, String> errors = new HashMap<>();

    //     result.getFieldErrors().forEach(err -> {
    //         errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
    //     });
    //     return ResponseEntity.badRequest().body(errors);
    // }
}
