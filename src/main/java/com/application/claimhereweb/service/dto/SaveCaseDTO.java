package com.application.claimhereweb.service.dto;

import java.sql.Date;

import com.application.claimhereweb.validation.IsRequired;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
public class SaveCaseDTO {
    
    @IsRequired
    private String title;

    @IsRequired
    private String description;

    @PastOrPresent(message = "debe ser del pasado o el presente")
    private Date event_date;
    
}
