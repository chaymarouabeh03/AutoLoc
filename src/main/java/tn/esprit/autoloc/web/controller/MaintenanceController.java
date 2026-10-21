package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance maintenance) {
        return new ResponseEntity<>(maintenanceService.create(maintenance), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> findAll() {
        return ResponseEntity.ok(maintenanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> findById(@PathVariable Long id) {
        return maintenanceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        return ResponseEntity.ok(maintenanceService.update(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        maintenanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}