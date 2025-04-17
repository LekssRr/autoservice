package ru.autoservice.service;

import ru.autoservice.dto.AutoDto;
import ru.autoservice.dto.ServiceCompanyDto;

import java.util.List;

public interface ServiceCompanyService {
    List<ServiceCompanyDto> getAllServiceCompany();
    List<AutoDto> getAllVinToServiceCompany(String nameServiceCompany);
    Boolean addServiceCompany(String nameServiceCompany);
    Boolean deleteServiceCompany(String nameServiceCompany);
    Boolean deleteAllServiceCompany();
    Boolean updateServiceCompany(String oldSc, String newSC);
}
