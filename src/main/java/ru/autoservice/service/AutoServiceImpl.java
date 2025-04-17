package ru.autoservice.service;

import ru.autoservice.dto.AutoDto;

import java.util.List;

public class AutoServiceImpl implements AutoService{
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
    public Boolean addAuto(String vinCode, String nameServiceCompany) {
        return null;
    }

    @Override
    public Boolean deleteAuto(String vinCode) {
        return null;
    }

    @Override
    public Boolean deleteAllAuto() {
        return null;
    }

    @Override
    public Boolean updateAuto(String vinCode, String newNameSC) {
        return null;
    }
}
