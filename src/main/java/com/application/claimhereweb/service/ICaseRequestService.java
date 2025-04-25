package com.application.claimhereweb.service;

import com.application.claimhereweb.service.dto.ResponseCaseRequestDTO;
import com.application.claimhereweb.service.dto.SaveCaseRequestDTO;

public interface ICaseRequestService {

    public ResponseCaseRequestDTO saveCaseRequest(SaveCaseRequestDTO SaveCaseDTO, Long id_customer);

}
