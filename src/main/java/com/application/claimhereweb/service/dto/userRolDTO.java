package com.application.claimhereweb.service.dto;

import lombok.Data;

@Data
public class userRolDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String tipo;
}