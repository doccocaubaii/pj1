package edu.hust.project1.controller;

import edu.hust.project1.dto.XeDTO;
import edu.hust.project1.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class XeController {
    @Autowired
    XeService xeService;

    @GetMapping("/tat-ca-xe")
    ResponseEntity<?> getAll(@RequestParam(required = false) Integer idDaiLy) {
        if (idDaiLy == null)
        return ResponseEntity.ok(xeService.getAll());
        else return ResponseEntity.ok(xeService.getAllByDaily(idDaiLy));
    }

    @GetMapping("/xe")
    ResponseEntity<?> getById(@RequestParam Integer id) {
        XeDTO xe = xeService.getById(id);
        if (xe == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(xe);
    }

    @PostMapping("/xe")
    ResponseEntity<?> createNew(@RequestBody XeDTO xe) {
        xe.setId(null);
        try {
            return ResponseEntity.ok(xeService.save(xe));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create failed.");
        }
    }

    @PutMapping("/xe")
    ResponseEntity<?> updateById(@RequestParam Integer id, @RequestBody XeDTO xe) {
        xe.setId(id);
        try {
            return ResponseEntity.ok(xeService.save(xe));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update failed.");
        }
    }

    @DeleteMapping("/xe")
    ResponseEntity<?> deleteById(@RequestParam Integer id) {
        try {
            if (xeService.deleteById(id)) return ResponseEntity.ok("Delete succeed.");
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete failed.");
        }
    }
}
