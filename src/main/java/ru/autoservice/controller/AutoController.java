package ru.autoservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.service.AutoService;
import ru.autoservice.service.AutoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller()
@RequestMapping("/auto")
public class AutoController {

    private AutoService autoService;

    public AutoController()
    {
    }
    public AutoController(AutoService newAutoService)
    {
        autoService = newAutoService;
    }
    @GetMapping()
    public ResponseEntity<String> getAllAuto() {
        String result = null;
        try {
            List<AutoDto> autoDtos = autoService.getAllAuto();
            result = autoDtos.stream()
                    .map(AutoDto::toString)
                    .collect(Collectors.toList()).toString();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAuto(@PathVariable String id) {
        try {
            return ResponseEntity.ok(autoService.getAuto(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PostMapping("/{id}/{sc}")
    public ResponseEntity<String> postAuto(@PathVariable String id, @PathVariable String sc) {
        try {
            Boolean res = autoService.addAuto(id, sc);
            return ResponseEntity.ok(res.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllAuto() {
        String result = "Ошибка";
        try {
            Boolean res = autoService.deleteAllAuto();
            return ResponseEntity.ok(res.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuto(@PathVariable String id) {
        try {
            Boolean result = autoService.deleteAuto(id);
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping("/{oldSC}/{newSC}")
    public ResponseEntity<String> putAuto(@PathVariable String oldSC, @PathVariable String newSC) {
        try {
            return ResponseEntity.ok("PUT");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
