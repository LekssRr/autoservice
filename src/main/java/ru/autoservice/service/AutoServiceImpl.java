package ru.autoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.entity.AutoEntity;
import ru.autoservice.entity.ServiceCompanyEntity;
import ru.autoservice.repository.AutoRepository;
import ru.autoservice.repository.ServiceCompanyRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final ServiceCompanyRepository serviceCompanyRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository, ServiceCompanyRepository serviceCompanyRepository) {
        this.autoRepository = autoRepository;
        this.serviceCompanyRepository = serviceCompanyRepository;
    }


    @Override
    public AutoDto getAuto(String vinCode) {
        if (isCurrentVin(vinCode)) {
            AutoDto result = null;
            if (autoRepository.findById(vinCode).isPresent()) {
                result = new AutoDto(autoRepository.findById(vinCode).get().getVinCode(), autoRepository.findById(vinCode).get().getServiceCompany().getNameServiceCompany());
            }
            return result;
        }
        return null;
    }

    @Override
    public String getServiceCompany(AutoDto autoDto) {
        return autoDto.getNameServiceCompany();
    }

    @Override
    public List<AutoDto> getAllAuto() {
        return autoRepository.findAll()
                .stream()
                .map(autoEntity -> {
                    return new AutoDto(autoEntity.getVinCode(), autoEntity.getServiceCompany().getNameServiceCompany());
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoDto> getAllAutoToServiceCompany(String nameServiceCompany) {
        return autoRepository.findAll()
                .stream()
                .filter(autoEntity -> {
                    return autoEntity.getServiceCompany().getNameServiceCompany().equals(nameServiceCompany);
                })
                .map(autoEntity -> {
                    return new AutoDto(autoEntity.getVinCode(), autoEntity.getServiceCompany().getNameServiceCompany());
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Boolean addAuto(String vinCode, String nameServiceCompany) {
        if (isCurrentVin(vinCode)) {
            if (isServiceCompany(nameServiceCompany)) {
                if (this.isAuto(vinCode)) {
                    AutoEntity addAuto = new AutoEntity(vinCode, new ServiceCompanyEntity(nameServiceCompany));
                    autoRepository.save(addAuto);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteAuto(String vinCode) {
        if (isCurrentVin(vinCode)) {
            if (this.isAuto(vinCode)) {
                autoRepository.deleteById(vinCode);
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteAllAuto() {
        autoRepository.deleteAll();
        return true;
    }

    @Override
    @Transactional
    public Boolean updateAuto(String vinCode, String newNameSC) {
        return null;
    }

    private Boolean isServiceCompany(String nameServiceCompany) {
        List<ServiceCompanyEntity> serviceCompanyEntities = serviceCompanyRepository.findAll();
        Set<String> serviceCompanySet = new HashSet<>();
        serviceCompanySet = serviceCompanyEntities
                .stream()
                .map(ServiceCompanyEntity::getNameServiceCompany)
                .collect(Collectors.toSet());
        if (!serviceCompanySet.add(nameServiceCompany)) {
            return true;
        }
        return false;
    }

    private Boolean isAuto(String vinCode) {
        List<AutoDto> autoDtos = this.getAllAuto();
        Set<String> vinSet = new HashSet<>();
        vinSet = autoDtos
                .stream()
                .map(AutoDto::getVinCode)
                .collect(Collectors.toSet());
        if (!vinSet.add(vinCode)) {
            return true;
        }
        return false;
    }

    private boolean isCurrentVin(String vinCode) {
        return vinCode.length() == 17;
    }
}
