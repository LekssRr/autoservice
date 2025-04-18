package ru.autoservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.dto.ServiceCompanyDto;
import ru.autoservice.repository.AutoRepository;
import ru.autoservice.repository.ServiceCompanyRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ServiceCompanyServiceImpl implements ServiceCompanyService{
    private final ServiceCompanyRepository serviceCompanyRepository;
    private final AutoRepository autoRepository;

    public ServiceCompanyServiceImpl(ServiceCompanyRepository serviceCompanyRepository, AutoRepository autoRepository) {
        this.serviceCompanyRepository = serviceCompanyRepository;
        this.autoRepository = autoRepository;
    }

    @Override
    public List<ServiceCompanyDto> getAllServiceCompany() {
        return null;
    }

    @Override
    public List<AutoDto> getAllVinToServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    @Transactional
    public Boolean addServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    @Transactional
    public Boolean deleteServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    @Transactional
    public Boolean deleteAllServiceCompany() {
        return null;
    }

    @Override
    @Transactional
    public Boolean updateServiceCompany(String oldSc, String newSC) {
        return null;
    }
}
