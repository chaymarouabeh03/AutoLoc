package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @PostMapping
    public ResponseEntity<Paiement> create(@RequestBody Paiement paiement) {
        return new ResponseEntity<>(paiementService.create(paiement), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Paiement>> findAll() {
        return ResponseEntity.ok(paiementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> findById(@PathVariable Long id) {
        return paiementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        return ResponseEntity.ok(paiementService.update(paiement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paiementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
