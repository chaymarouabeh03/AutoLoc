package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<Vehicule> create(@RequestBody Vehicule vehicule) {
        return new ResponseEntity<>(vehiculeService.create(vehicule), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> findAll() {
        return ResponseEntity.ok(vehiculeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> findById(@PathVariable Long id) {
        return vehiculeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.update(vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}