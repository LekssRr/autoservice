package ru.autoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.dto.ServiceCompanyDto;
import ru.autoservice.entity.AutoEntity;
import ru.autoservice.entity.ServiceCompanyEntity;
import ru.autoservice.repository.AutoRepository;
import ru.autoservice.repository.ServiceCompanyRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
        List<ServiceCompanyEntity> serviceCompanyEntities = serviceCompanyRepository.findAll();
        List<ServiceCompanyDto> result = new ArrayList<>();
        for (int i = 0; i <= serviceCompanyEntities.size() - 1; i++) {
            result.add(new ServiceCompanyDto(serviceCompanyEntities.get(i).getNameServiceCompany()));
        }
        return result;
    }

    @Override
    public List<AutoDto> getAllVinToServiceCompany(String nameServiceCompany) {
        List<AutoDto> result = new ArrayList<>();
        if (!serviceCompanyRepository.findById(nameServiceCompany).isPresent()) {

            result = serviceCompanyRepository.findById(nameServiceCompany).get().getAutoEntities()
                    .stream()
                    .map(autoEntity -> {
                        return new AutoDto(autoEntity.getVinCode(), autoEntity.getServiceCompany().getNameServiceCompany());
                    })
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Override
    @Transactional
    public Boolean addServiceCompany(String nameServiceCompany) {
        if (this.namesServiceCompany().add(nameServiceCompany)) {
            serviceCompanyRepository.save(new ServiceCompanyEntity());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteServiceCompany(String nameServiceCompany) {
        if (!this.namesServiceCompany().add(nameServiceCompany)) {
            serviceCompanyRepository.deleteById(nameServiceCompany);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteAllServiceCompany() {
        serviceCompanyRepository.deleteAll();
        return true;
    }

    @Override
    @Transactional
    public Boolean updateServiceCompany(String oldSc, String newSC) {
        if(!this.serviceCompanyRepository.findById(oldSc).isPresent())
        {
            ServiceCompanyEntity serviceCompanyEntities = serviceCompanyRepository.findById(oldSc).get();
            serviceCompanyRepository.save(new ServiceCompanyEntity(newSC));
            List<AutoEntity> autoEntityList = autoRepository.findAll()
                    .stream()
                    .filter(autoEntity -> autoEntity.getServiceCompany().getNameServiceCompany().equals(oldSc))
                    .collect(Collectors.toList());
            serviceCompanyRepository.deleteById(oldSc);
            for(int i = 0; i<=autoEntityList.size()-1; i++)
            {
                autoRepository.deleteById(autoEntityList.get(i).getVinCode());
            }
            for(int i = 0; i<=autoEntityList.size()-1; i++)
            {
                autoEntityList.get(i).setServiceCompany(new ServiceCompanyEntity(newSC));
                autoRepository.save(autoEntityList.get(i));
            }
            return true;
        }
        return false;
    }
    private Set<String> namesServiceCompany() {
        List<ServiceCompanyDto> serviceCompanyDtoList = this.getAllServiceCompany();
        Set<String> nameServiceCompanySet = new HashSet<>();
        for (int i = 0; i <= serviceCompanyDtoList.size() - 1; i++) {
            nameServiceCompanySet.add(serviceCompanyDtoList.get(i).getNameServiceCompany());
        }
        return nameServiceCompanySet;
    }
}
