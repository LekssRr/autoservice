package ru.autoservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.dto.ServiceCompanyDto;
import ru.autoservice.service.ServiceCompanyService;
import ru.autoservice.service.ServiceCompanyServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller()
@RequestMapping("/servicecompany")
public class ServiceCompanyController {

    private ServiceCompanyService serviceCompanyService;

    public ServiceCompanyController()
    {

    }
    public ServiceCompanyController(ServiceCompanyService newServiceCompanyService)
    {
        serviceCompanyService = newServiceCompanyService;
    }

    @GetMapping()
    public ResponseEntity<String> getAllServiceCompany() {
        String result = null;
        try {
            List<ServiceCompanyDto> serviceCompany = serviceCompanyService.getAllServiceCompany();
            result = serviceCompany.stream()
                    .map(ServiceCompanyDto::toString)
                    .collect(Collectors.toList()).toString();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getServiceCompany(@PathVariable String id) {
        String vinList = null;
        try {
            vinList = serviceCompanyService.getAllVinToServiceCompany(id)
                    .stream()
                    .map(AutoDto::toString)
                    .collect(Collectors.toList()).toString();
            return ResponseEntity.ok(vinList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(vinList);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> postServiceCompany(@PathVariable String id) {
        Boolean result = null;
        try {
            result = serviceCompanyService.addServiceCompany(id);
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllServiceCompany() {
        Boolean result = false;
        try {
            result = serviceCompanyService.deleteAllServiceCompany();
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServiceCompany(@PathVariable String id) {
        Boolean result = false;
        try {
            result = serviceCompanyService.deleteServiceCompany(id);
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping("/{oldSC}/{newSC}")
    public ResponseEntity<String> putServiceCompany(@PathVariable String oldSC, String newSc) {
        Boolean result = false;
        try {
            result = serviceCompanyService.updateServiceCompany(oldSC, newSc);
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}

