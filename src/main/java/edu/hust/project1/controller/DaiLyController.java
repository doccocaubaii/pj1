package edu.hust.project1.controller;

import edu.hust.project1.dto.DaiLyDTO;
import edu.hust.project1.service.DaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DaiLyController {
    @Autowired
    DaiLyService daiLyService;

    @GetMapping("/tat-ca-dai-ly")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(daiLyService.getAll());
    }

    @GetMapping("/dai-ly")
    ResponseEntity<?> getById(@RequestParam(required = false) Integer id) {
        DaiLyDTO daiLy = daiLyService.getById(id);
        if (daiLy == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(daiLy);
    }

    @PostMapping("/dai-ly")
    ResponseEntity<?> createNew(@RequestBody DaiLyDTO daiLy) {
        daiLy.setId(null);
        try {
            return ResponseEntity.ok(daiLyService.save(daiLy));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create failed.");
        }
    }

    @PutMapping("/dai-ly")
    ResponseEntity<?> updateById(@RequestParam Integer id, @RequestBody DaiLyDTO daiLy) {
        daiLy.setId(id);
        try {
            return ResponseEntity.ok(daiLyService.save(daiLy));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update failed.");
        }
    }

    @DeleteMapping("/dai-ly")
    ResponseEntity<?> deleteById(@RequestParam Integer id) {
        try {
            if (daiLyService.deleteById(id)) return ResponseEntity.ok("Delete succeed.");
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete failed.");
        }
    }

}
