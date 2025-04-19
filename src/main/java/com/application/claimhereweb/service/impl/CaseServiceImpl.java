package com.application.claimhereweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.claimhereweb.model.entity.Area;
import com.application.claimhereweb.model.entity.Case;
import com.application.claimhereweb.model.entity.Customer;
import com.application.claimhereweb.model.entity.User;
import com.application.claimhereweb.model.entity.enumEntity.StatusOfCase;
import com.application.claimhereweb.model.repository.AreaRepository;
import com.application.claimhereweb.model.repository.CaseRepository;
import com.application.claimhereweb.model.repository.CustomerRepository;
import com.application.claimhereweb.service.ICaseService;
import com.application.claimhereweb.service.dto.ResponseCaseDTO;
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
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public ResponseCaseDTO saveCase(SaveCaseDTO dto, Long id_customer, Long id_area) {
        logger.info("Registrando caso con título: {}", dto.getTitle());

        String areaName = areaRepository.findNameById(id_area);
        if (areaName == null) {
            logger.warn("Área con ID {} no encontrada. Cancelando registro.", id_area);
            throw new RuntimeException("Área no encontrada");
        }
    
        String customerName = customerRepository.findCustomerUserNameById(id_customer);
        if (customerName == null) {
            logger.warn("Cliente con ID {} no encontrado. Cancelando registro.", id_customer);
            throw new RuntimeException("Cliente no encontrado");
        }
    
        Case legalCase = modelMapper.map(dto, Case.class);
        legalCase.setArea(new Area() {{ setId(id_area); setName(areaName); }});
        legalCase.setCustomer(new Customer() {{ setId(id_customer); setUser(new User() {{ setName(customerName); }}); }});
        legalCase.setStatus(StatusOfCase.EN_PROCESO);
        legalCase.setPriority(dto.getPriority());

        try {
            Case savedCase = caseRepository.save(legalCase);
            ResponseCaseDTO response = modelMapper.map(savedCase, ResponseCaseDTO.class);
            response.setArea(savedCase.getArea().getName());
            response.setCustomer(savedCase.getCustomer().getUser().getName());
            logger.info("Caso guardado con ID: {}", savedCase.getId());
            return response; 
        } catch (Exception e) {
            logger.error("Error al guardar el caso:", e);
            return null;
        }
    }

}