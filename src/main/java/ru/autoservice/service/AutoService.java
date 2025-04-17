package ru.autoservice.service;

import ru.autoservice.dto.AutoDto;

import java.util.List;

public interface AutoService {
    AutoDto getAuto(String vinCode);
    String getServiceCompany(AutoDto autoDto);
    List<AutoDto> getAllAuto();
    List<AutoDto> getAllAutoToServiceCompany(String nameServiceCompany);
    Boolean addAuto(String vinCode, String nameServiceCompany);
    Boolean deleteAuto(String vinCode);
    Boolean deleteAllAuto();
    Boolean updateAuto(String vinCode, String newNameSC);
}
