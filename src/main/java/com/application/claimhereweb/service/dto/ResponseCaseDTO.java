package com.application.claimhereweb.service.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ResponseCaseDTO {
    
    private Long id;
    private String title;
    private String description;

    private String case_type;
    private String case_status;
    private String customer;
    private Date startDate;
}
