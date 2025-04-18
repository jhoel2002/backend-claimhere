package com.application.claimhereweb.service;

import com.application.claimhereweb.model.entity.Case;
import com.application.claimhereweb.service.dto.SaveCaseDTO;

public interface ICaseService {
    public Case saveCase(SaveCaseDTO value_case);
}