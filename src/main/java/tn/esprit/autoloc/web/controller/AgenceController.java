package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public ResponseEntity<Agence> create(@RequestBody Agence agence) {
        return new ResponseEntity<>(agenceService.create(agence), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agence>> findAll() {
        return ResponseEntity.ok(agenceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> findById(@PathVariable Long id) {
        return agenceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.update(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}