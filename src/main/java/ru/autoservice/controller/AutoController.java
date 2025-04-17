package ru.autoservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller()
@RequestMapping("/auto")
public class AutoController {

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllAuto() {
        List<String> result = new ArrayList<>();
        try {
//            List<AutoDto> autoDtos = autoServiceImpl.getAllAuto();
//            result = autoDtos.stream()
//                    .map(AutoDto::toString)
//                    .collect(Collectors.toList());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAuto(@PathVariable String id) {
        try {
            return ResponseEntity.badRequest().body("Ok"); //ResponseEntity.ok(autoServiceImpl.getAuto(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PostMapping("/{id}/{sc}")
    public ResponseEntity<String> postAuto(@PathVariable String id, @PathVariable String sc) {
        try {
            Boolean res = false; //autoServiceImpl.addAuto(id, sc);
            return ResponseEntity.ok(res.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllAuto() {
        String result = "Ошибка";
        try {
            Boolean res = false;//autoServiceImpl.deleteAllAuto();
            return ResponseEntity.ok(res.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuto(@PathVariable String id) {
        try {
            Boolean result = false;//autoServiceImpl.deleteAuto(id);
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping()
    public ResponseEntity putAuto() {
        try {
            return ResponseEntity.ok("PUT");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
