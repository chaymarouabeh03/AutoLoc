package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    public ResponseEntity<Contrat> create(@RequestBody Contrat contrat) {
        return new ResponseEntity<>(contratService.create(contrat), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contrat>> findAll() {
        return ResponseEntity.ok(contratService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> findById(@PathVariable Long id) {
        return contratService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return ResponseEntity.ok(contratService.update(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.delete(id);
        return ResponseEntity.noContent().build();
    }
}