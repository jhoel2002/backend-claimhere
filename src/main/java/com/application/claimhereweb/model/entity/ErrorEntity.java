package com.application.claimhereweb.model.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorEntity {
    
    private String message;
    private String error;
    private int status;
    private Date date;
}
