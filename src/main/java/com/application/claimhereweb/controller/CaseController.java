package com.application.claimhereweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.claimhereweb.service.dto.ResponseCaseDTO;
//import com.application.claimhereweb.model.entity.Case;
import com.application.claimhereweb.service.dto.SaveCaseDTO;
import com.application.claimhereweb.service.impl.CaseServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200", originPatterns = "*")
@RequestMapping("api/cases")
public class CaseController {

    @Autowired
    private CaseServiceImpl caseService;

    @PostMapping("/registerCase/cust/{id_customer}/area/{id_area}")
    // @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> createCase(@Valid @RequestBody SaveCaseDTO value_case, @PathVariable Long id_customer, @PathVariable Long id_area) {
        ResponseCaseDTO response = caseService.saveCase(value_case, id_customer, id_area);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

