package ru.autoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.repository.AutoRepository;
import ru.autoservice.repository.ServiceCompanyRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AutoServiceImpl implements AutoService{

    private final AutoRepository autoRepository;
    private final ServiceCompanyRepository serviceCompanyRepository;
    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository, ServiceCompanyRepository serviceCompanyRepository) {
        this.autoRepository = autoRepository;
        this.serviceCompanyRepository = serviceCompanyRepository;
    }

    @Override
    public AutoDto getAuto(String vinCode) {
        return null;
    }

    @Override
    public String getServiceCompany(AutoDto autoDto) {
        return "";
    }

    @Override
    public List<AutoDto> getAllAuto() {
        return null;
    }

    @Override
    public List<AutoDto> getAllAutoToServiceCompany(String nameServiceCompany) {
        return null;
    }

    @Override
    @Transactional
    public Boolean addAuto(String vinCode, String nameServiceCompany) {
        return null;
    }

    @Override
    @Transactional
    public Boolean deleteAuto(String vinCode) {
        return null;
    }

    @Override
    @Transactional
    public Boolean deleteAllAuto() {
        return null;
    }

    @Override
    @Transactional
    public Boolean updateAuto(String vinCode, String newNameSC) {
        return null;
    }
}
