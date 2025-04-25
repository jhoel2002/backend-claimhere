package com.application.claimhereweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.claimhereweb.exceptions.ResourceNotFoundException;
import com.application.claimhereweb.model.entity.Customer;
import com.application.claimhereweb.model.entity.LegalCase;
import com.application.claimhereweb.model.entity.User;
import com.application.claimhereweb.model.entity.enumEntity.CaseStatus;
import com.application.claimhereweb.model.repository.CustomerRepository;
import com.application.claimhereweb.model.repository.LegalCaseRepository;
import com.application.claimhereweb.service.ICaseService;
import com.application.claimhereweb.service.dto.ResponseCaseDTO;
import com.application.claimhereweb.service.dto.SaveCaseDTO;

@Service
public class CaseServiceImpl implements ICaseService {

    private static final Logger logger = LoggerFactory.getLogger(CaseServiceImpl.class);

    @Autowired
    private LegalCaseRepository legalCaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override

    @Transactional
    public ResponseCaseDTO saveCase(SaveCaseDTO dto, Long id_customer) {
        logger.info("Registrando caso con título: {}", dto.getTitle());

        /*
         * String areaName = Optional.ofNullable(areaRepository.findNameById(id_area))
         * .orElseThrow(() -> {
         * return new ResourceNotFoundException("Área no encontrada");
         * });
         */

        String customerName = Optional.ofNullable(customerRepository.findCustomerUserNameById(id_customer))
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Cliente no encontrado");
                });
        LegalCase legalCase = modelMapper.map(dto, LegalCase.class);
        // legalCase.setArea(new Area() {{ setId(id_area); setName(areaName); }});
        legalCase.setCustomer(new Customer() {
            {
                setId(id_customer);
                setUser(new User() {
                    {
                        setName(customerName);
                    }
                });
            }
        });
        legalCase.setStatus_case(CaseStatus.Nuevo);

        LegalCase savedCase = legalCaseRepository.save(legalCase);
        return responseCase(savedCase);
    }

    public ResponseCaseDTO responseCase(LegalCase caseModel) {
        ResponseCaseDTO response = modelMapper.map(caseModel, ResponseCaseDTO.class);
        // response.setArea(caseModel.getArea().getName());
        response.setCustomer(caseModel.getCustomer().getUser().getName());
        logger.info("Caso guardado con ID: {}", caseModel.getId());
        return response;
    }
}