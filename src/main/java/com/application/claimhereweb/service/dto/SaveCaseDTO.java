package com.application.claimhereweb.service.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SaveCaseDTO {
    private String title;
    private String description;

    private Long id_area;
    private Long id_customer;
    private Long id_lawyer;

    private Date event_date;
    private String location;

    private String status;
    private String priority;
}
