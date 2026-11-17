package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    public ResponseEntity<Equipement> create(@RequestBody Equipement equipement) {
        return new ResponseEntity<>(equipementService.create(equipement), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> findAll() {
        return ResponseEntity.ok(equipementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> findById(@PathVariable Long id) {
        return equipementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> update(@PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        return ResponseEntity.ok(equipementService.update(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}