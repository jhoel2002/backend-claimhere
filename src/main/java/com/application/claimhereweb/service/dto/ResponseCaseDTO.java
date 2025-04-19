package com.application.claimhereweb.service.dto;

import java.sql.Date;

import com.application.claimhereweb.model.entity.enumEntity.Priority;

import lombok.Data;

@Data
public class ResponseCaseDTO {
    
    private Long id;
    private String title;
    private String description;

    private String area;
    private String customer;
    private Date event_date;
    private String location;
    private Priority priority;
}
