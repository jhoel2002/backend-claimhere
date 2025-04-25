package com.application.claimhereweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.claimhereweb.service.ICaseRequestService;
import com.application.claimhereweb.service.dto.ResponseCaseRequestDTO;
import com.application.claimhereweb.service.dto.SaveCaseRequestDTO;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200", originPatterns = "*")
@RequestMapping("api/casesRequest")
public class CaseRequestController {

    @Autowired
    private ICaseRequestService caseRequestService;

    @PostMapping("/registerCaseRequest/cust/{id_customer}")
    // @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> createCase(@Valid @RequestBody SaveCaseRequestDTO value_case,
            @PathVariable Long id_customer) {
        ResponseCaseRequestDTO response = caseRequestService.saveCaseRequest(value_case, id_customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
