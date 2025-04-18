package com.application.claimhereweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.claimhereweb.model.entity.Area;
import com.application.claimhereweb.model.entity.Case;
import com.application.claimhereweb.model.entity.Customer;
import com.application.claimhereweb.model.entity.Lawyer;
import com.application.claimhereweb.model.repository.AreaRepository;
import com.application.claimhereweb.model.repository.CaseRepository;
import com.application.claimhereweb.model.repository.CustomerRepository;
import com.application.claimhereweb.model.repository.LawyerRepository;
import com.application.claimhereweb.service.ICaseService;
import com.application.claimhereweb.service.dto.SaveCaseDTO;

@Service
public class CaseServiceImpl implements ICaseService {

    private static final Logger logger = LoggerFactory.getLogger(CaseServiceImpl.class);

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LawyerRepository lawyerRepository;

    @Override
    public Case saveCase(SaveCaseDTO dto) {
        if (dto == null) {
            logger.warn("Intento de guardar un caso desde un DTO nulo");
            return null;
        }

        logger.info("Registrando caso con título: {}", dto.getTitle());

        // Buscar entidades relacionadas
        Area area = areaRepository.findById(dto.getId_area()).orElse(null);
        Customer customer = customerRepository.findById(dto.getId_customer()).orElse(null);
        Lawyer lawyer = null;

        if (dto.getId_lawyer() != null) {
            lawyer = lawyerRepository.findById(dto.getId_lawyer()).orElse(null);
        }

        if (area == null || customer == null) {
            logger.warn("Área o Cliente no encontrado. Cancelando registro.");
            return null;
        }

        // Crear entidad Case
        Case legalCase = new Case();
        legalCase.setTitle(dto.getTitle());
        legalCase.setDescription(dto.getDescription());
        legalCase.setEvent_date(dto.getEvent_date());
        legalCase.setLocation(dto.getLocation());
        legalCase.setPriority(dto.getPriority());
        legalCase.setStatus(dto.getStatus());

        legalCase.setArea(area);
        legalCase.setCustomer(customer);
        legalCase.setLawyer(lawyer);

        try {
            Case savedCase = caseRepository.save(legalCase);
            logger.info("Caso guardado con ID: {}", savedCase.getId());
            return savedCase;
        } catch (Exception e) {
            logger.error("Error al guardar el caso:", e);
            return null;
        }
    }
}