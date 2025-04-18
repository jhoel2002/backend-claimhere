package com.application.claimhereweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.application.claimhereweb.model.entity.Case;
import com.application.claimhereweb.service.ICaseService;
import com.application.claimhereweb.service.dto.SaveCaseDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200", originPatterns = "*")
@RequestMapping("api/cases")
public class CaseController {

    @Autowired
    private ICaseService caseService;

    @PostMapping("/registerCase")
    // @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<String> createCase(@RequestBody SaveCaseDTO value_case) {
        try {
            caseService.saveCase(value_case);
            return new ResponseEntity<>("Caso legal registrado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el caso legal: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
