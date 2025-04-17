package ru.autoservice.service;

import ru.autoservice.dto.AutoDto;
import ru.autoservice.dto.ServiceCompanyDto;

import java.util.List;

public class ServiceCompanyServiceImpl implements ServiceCompanyService{
    @Override
    public List<ServiceCompanyDto> getAllServiceCompany() {
        return null;
    }

    @Override
    public List<AutoDto> getAllVinToServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    public Boolean addServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    public Boolean deleteServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    public Boolean deleteAllServiceCompany() {
        return null;
    }

    @Override
    public Boolean updateServiceCompany(String oldSc, String newSC) {
        return null;
    }
}
